package com.habench.fulfilquote.dao;

import com.habench.fulfilquote.dao.TariffExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class BundlePolicy {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void assemble(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        TariffExecutor.prepare(value);
    }
}
