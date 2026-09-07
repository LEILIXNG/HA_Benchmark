package com.habench.pricingapprove.dao;

import com.habench.pricingapprove.dao.CatalogExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class InvoiceValidator {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void submit(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        CatalogExecutor.dispatch(value);
    }
}
