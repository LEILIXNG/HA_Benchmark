package com.habench.cmdi1044n.service;

import com.habench.cmdi1044n.service.SinkHandler;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Sanitizer05 {
    private static final Set<String> ALLOWED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void apply(String value) {
        if (!ALLOWED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        SinkHandler.execute(value);
    }
}
