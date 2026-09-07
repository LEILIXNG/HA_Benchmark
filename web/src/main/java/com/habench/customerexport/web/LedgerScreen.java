package com.habench.customerexport.web;

import com.habench.customerexport.web.BatchPlanSelector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class LedgerScreen {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void route(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        BatchPlanSelector.resolve(value);
    }
}
