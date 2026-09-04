package com.habench.inventoryapprove.service;

import com.habench.inventoryapprove.service.CatalogExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ManifestFilter {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void reconcile(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        CatalogExecutor.normalize(value);
    }
}
