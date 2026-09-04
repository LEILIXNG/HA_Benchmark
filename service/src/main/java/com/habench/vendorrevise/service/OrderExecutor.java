package com.habench.vendorrevise.service;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class OrderExecutor {

    public static void stage(String value) {
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
