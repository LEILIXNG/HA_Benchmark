package com.habench.path1028n.dao;

import com.habench.common.TaintOracle;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class SinkHandler {
    private static final String ROOT = "/var/lib/habench/data/";

    public static void execute(String value) {
        Path root = Paths.get(ROOT).toAbsolutePath().normalize();
        Path resolved = root.resolve(value).normalize();
        if (!resolved.startsWith(root)) {
            throw new IllegalArgumentException("path escapes root");
        }
        TaintOracle.reached("JAVA-PATH-1028-N", resolved.toString());
        try {
            Files.readAllBytes(resolved);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
