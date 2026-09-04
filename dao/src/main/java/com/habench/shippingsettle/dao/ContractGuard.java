package com.habench.shippingsettle.dao;

import com.habench.shippingsettle.dao.BatchTranslator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ContractGuard {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void translate(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        BatchTranslator.dispatch(value);
    }
}
