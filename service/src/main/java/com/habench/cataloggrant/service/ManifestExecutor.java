package com.habench.cataloggrant.service;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class ManifestExecutor {

    public static void collect(String value) {
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
