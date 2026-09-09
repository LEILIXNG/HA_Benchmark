package com.habench.vendorassign.service;

import com.habench.vendorassign.service.ManifestEvaluator;
import java.util.regex.Pattern;

public final class CatalogGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void route(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestEvaluator.enrich(value);
    }
}
