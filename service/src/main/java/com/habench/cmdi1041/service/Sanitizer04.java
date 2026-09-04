package com.habench.cmdi1041.service;

import com.habench.cmdi1041.service.Handler04Dispatcher;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Sanitizer04 {
    private static final Set<String> ALLOWED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void apply(String value) {
        if (!ALLOWED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        Handler04Dispatcher.apply(value);
    }
}
