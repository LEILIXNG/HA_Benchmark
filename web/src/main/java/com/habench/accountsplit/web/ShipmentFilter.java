package com.habench.accountsplit.web;

import com.habench.accountsplit.web.ShipmentExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ShipmentFilter {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void assemble(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ShipmentExecutor.dispatch(value);
    }
}
