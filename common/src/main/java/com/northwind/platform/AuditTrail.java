package com.northwind.platform;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 处理链路的审计埋点：把语句、命令、路径交给外部系统之前先记一笔。
 *
 * <p>{@code emit} 记的是即将原样下发的内容，{@code bound} 记的是值已经与语句
 * 分离（参数化绑定、不经 shell 解释等）的情形 —— 两者排障时含义完全不同。
 *
 * <p>输出路径由系统属性 {@code northwind.audit.out} 指定，缺省为 ./audit-trail.jsonl。
 */
public final class AuditTrail {

    private static final Path OUT =
            Paths.get(System.getProperty("northwind.audit.out", "audit-trail.jsonl"));

    private AuditTrail() {
    }

    /** 内容将被原样下发。 */
    public static synchronized void emit(String stage, String detail) {
        record(stage, detail, false);
    }

    /** 值已与语句分离，不参与语法。 */
    public static synchronized void bound(String stage, String detail) {
        record(stage, detail, true);
    }

    /**
     * 数出当前调用栈里属于本次业务处理的帧数 —— 即请求从入口流到这里实际穿越的
     * 方法调用层数。平台公共类与启动类不算业务链路的一环。
     */
    private static int chainDepth() {
        int n = 0;
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            if (business(e.getClassName())) {
                n++;
            }
        }
        return n;
    }

    /**
     * 从调用栈取出业务模块名。
     *
     * <p>此前是把标识作为字符串字面量传进来，等于每处埋点都写着自己属于哪条链路。
     * 改成运行时自取，业务代码里不再出现这个标识。
     */
    private static String moduleKey() {
        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
            String cn = e.getClassName();
            if (business(cn)) {
                String rest = cn.substring("com.northwind.".length());
                int dot = rest.indexOf('.');
                return dot < 0 ? rest : rest.substring(0, dot);
            }
        }
        return "unknown";
    }

    private static boolean business(String cn) {
        return cn.startsWith("com.northwind.")
                && !cn.startsWith("com.northwind.platform.")
                && !cn.startsWith("com.northwind.PlatformApplication");
    }

    private static void record(String stage, String detail, boolean bound) {
        String line = "{\"case\":\"" + moduleKey() + "\",\"stage\":\"" + stage
                + "\",\"payload\":\"" + escape(detail)
                + "\",\"neutralized\":" + bound
                + ",\"depth\":" + chainDepth() + "}";
        try (Writer w = Files.newBufferedWriter(OUT, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            w.write(line);
            w.write(System.lineSeparator());
        } catch (IOException e) {
            System.err.println("[audit] " + line);
        }
    }

    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"")
                .replace("\n", " ").replace("\r", " ");
    }
}
