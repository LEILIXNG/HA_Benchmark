package com.habench.pricingnotice.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class BatchLoader {
    private static final String ROOT = "/var/lib/habench/data/";

    public static void forward(String value) {
        String target = ROOT + value;
        TaintOracle.reached(target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
