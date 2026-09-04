package com.habench.accounttrace.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class BatchExecutor {

    public static void prepare(String value) {
        String command = "echo " + value;
        TaintOracle.reached(command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
