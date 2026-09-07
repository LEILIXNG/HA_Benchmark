package com.habench.billingreview.dao;

import com.habench.billingreview.dao.ManifestExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CatalogValidator {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void route(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ManifestExecutor.prepare(value);
    }
}
