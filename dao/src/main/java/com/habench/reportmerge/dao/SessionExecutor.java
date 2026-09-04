package com.habench.reportmerge.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class SessionExecutor {

    public static void route(String value) {
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
