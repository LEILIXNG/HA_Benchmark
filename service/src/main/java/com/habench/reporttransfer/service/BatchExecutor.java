package com.habench.reporttransfer.service;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class BatchExecutor {

    public static void publish(String value) {
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
