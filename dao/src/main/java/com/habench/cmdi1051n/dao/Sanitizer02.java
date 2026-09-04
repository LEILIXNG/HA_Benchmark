package com.habench.cmdi1051n.dao;

import com.habench.cmdi1051n.dao.Stage02;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Sanitizer02 {
    private static final Set<String> ALLOWED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void apply(String value) {
        if (!ALLOWED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        Stage02.handle(value);
    }
}
