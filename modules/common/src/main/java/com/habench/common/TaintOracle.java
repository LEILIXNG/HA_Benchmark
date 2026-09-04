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

    public static synchronized void reached(String caseId, String payload) {
        String line = "{\"case\":\"" + caseId + "\",\"payload\":\"" + escape(payload) + "\"}";
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
