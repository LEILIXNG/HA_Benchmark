package com.habench.cmdi1031.service;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class SinkHandler {

    public static void execute(String value) {
        TaintOracle.neutralized("JAVA-CMDI-1031", value);
        // 不经 shell：参数以数组形式直接交给进程，元字符不会被解释
        String[] argv = {"echo", value};
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
