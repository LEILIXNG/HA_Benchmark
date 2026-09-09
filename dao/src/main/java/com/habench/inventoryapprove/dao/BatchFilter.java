package com.habench.inventoryapprove.dao;

import com.habench.inventoryapprove.dao.ReceiptExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class BatchFilter {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void enrich(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ReceiptExecutor.compose(value);
    }
}
