package com.habench.cmdi1033n.web;

import com.habench.cmdi1033n.web.Stage00;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Sanitizer00 {
    private static final Set<String> ALLOWED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void apply(String value) {
        if (!ALLOWED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        Stage00.handle(value);
    }
}
