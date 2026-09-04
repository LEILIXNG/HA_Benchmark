package com.habench.shippingclose.service;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class OrderExecutor {

    public static void collect(String value) {
        TaintOracle.neutralized(value);
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
