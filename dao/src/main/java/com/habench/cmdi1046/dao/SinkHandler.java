package com.habench.cmdi1046.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class SinkHandler {

    public static void execute(String value) {
        String command = "echo " + value;
        TaintOracle.reached("JAVA-CMDI-1046", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
