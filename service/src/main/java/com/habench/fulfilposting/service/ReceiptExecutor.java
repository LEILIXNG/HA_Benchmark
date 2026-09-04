package com.habench.fulfilposting.service;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class ReceiptExecutor {

    public static void register(String value) {
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
