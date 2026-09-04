package com.habench.shippingsubmit.dao;

import com.habench.shippingsubmit.dao.BundleExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class QuoteFilter {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void submit(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        BundleExecutor.enrich(value);
    }
}
