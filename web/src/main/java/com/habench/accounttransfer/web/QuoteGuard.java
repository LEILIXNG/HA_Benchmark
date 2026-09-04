package com.habench.accounttransfer.web;

import com.habench.accounttransfer.web.CatalogExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class QuoteGuard {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void stage(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        CatalogExecutor.compose(value);
    }
}
