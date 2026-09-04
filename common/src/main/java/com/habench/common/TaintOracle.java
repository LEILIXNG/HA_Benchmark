package com.habench.common;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 动态验证用的探针：在真实危险调用之前记录「污点确实到达了 sink，且内容仍受外部控制」。
 *
 * <p>标答不是拍脑袋写的 —— 每条 vulnerable 用例都必须在 PoC 驱动下让本探针命中，
 * 每条 safe 用例都必须不命中（或命中时 payload 已被净化）。不满足的用例不进入主榜。
 *
 * <p>输出路径由系统属性 {@code habench.oracle.out} 指定，缺省为 ./oracle.jsonl。
 */
public final class TaintOracle {

    private static final Path OUT =
            Paths.get(System.getProperty("habench.oracle.out", "oracle.jsonl"));

    private TaintOracle() {
    }

    /** 污点到达了危险调用，且仍具攻击语义。 */
    public static synchronized void reached(String payload) {
        record(payload, false);
    }

    /**
     * 污点到达了那个 API，但走的是安全写法（参数化绑定、不经 shell 等），
     * 已不具攻击语义。动态验证据此区分"没到达"与"到达但已失效"。
     */
    public static synchronized void neutralized(String payload) {
        record(payload, true);
    }

    /**
     * 数出当前调用栈里属于本用例的帧数 —— 即污点从 controller 入口流到这里
     * 实际穿越的方法调用层数。标答里的 call_depth 由生成器推算，这里读的是
     * 运行时真相，两者必须一致，否则说明帧数模型错了。
     */
    private static int chainDepth() {
        int n = 0;
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            String cn = e.getClassName();
            // 用例自身的类都在 com.habench.<用例包>.* 下；
            // 探针所在的 common 包与启动类不算传播链的一环
            if (cn.startsWith("com.habench.")
                    && !cn.startsWith("com.habench.common.")
                    && !cn.startsWith("com.habench.HaBench")) {
                n++;
            }
        }
        return n;
    }

    /**
     * 从调用栈取出用例所在的包段作为标识。
     *
     * <p>此前是把用例 id 作为字符串字面量传进来，等于每个 sink 都写着自己是哪条用例——
     * 工具不用分析数据流就能定位漏洞。改成运行时自取，生成的代码里不再出现用例 id。
     */
    private static String caseKey() {
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            String cn = e.getClassName();
            if (cn.startsWith("com.habench.")
                    && !cn.startsWith("com.habench.common.")
                    && !cn.startsWith("com.habench.HaBench")) {
                String rest = cn.substring("com.habench.".length());
                int dot = rest.indexOf('.');
                return dot < 0 ? rest : rest.substring(0, dot);
            }
        }
        return "unknown";
    }

    private static void record(String payload, boolean neutralized) {
        String caseId = caseKey();
        String line = "{\"case\":\"" + caseId + "\",\"payload\":\"" + escape(payload)
                + "\",\"neutralized\":" + neutralized
                + ",\"depth\":" + chainDepth() + "}";
        try (Writer w = Files.newBufferedWriter(OUT, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            w.write(line);
            w.write(System.lineSeparator());
        } catch (IOException e) {
            // 探针失败不能影响被测代码的行为
            System.err.println("[oracle] " + line);
        }
    }

    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"")
                .replace("\n", " ").replace("\r", " ");
    }
}
