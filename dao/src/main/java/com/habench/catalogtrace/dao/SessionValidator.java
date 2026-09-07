package com.habench.catalogtrace.dao;

import com.habench.catalogtrace.dao.SessionTranslator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class SessionValidator {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void collect(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        SessionTranslator.submit(value);
    }
}
