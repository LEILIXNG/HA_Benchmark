package com.habench.accountissue.service;

import com.habench.accountissue.service.OrderResolver;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class QuoteValidator {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void reconcile(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        OrderResolver.reconcile(value);
    }
}
