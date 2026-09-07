package com.habench.paymentsync.service;

import com.habench.paymentsync.service.QuoteStrategySelector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class RefundPolicy {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void stage(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        QuoteStrategySelector.compose(value);
    }
}
