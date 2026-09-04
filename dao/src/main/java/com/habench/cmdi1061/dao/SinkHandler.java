package com.habench.cmdi1061.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;

public final class SinkHandler {

    public static void execute(String value) {
        String command = "echo " + value;
        TaintOracle.reached("JAVA-CMDI-1061", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
