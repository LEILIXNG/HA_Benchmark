package com.habench.orderreconcile.web;

import com.habench.orderreconcile.web.CatalogExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class PaymentGuard {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void assemble(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        CatalogExecutor.forward(value);
    }
}
