package com.habench.vendorverify.web;

import com.habench.vendorverify.web.CatalogEvaluator;
import java.util.regex.Pattern;

public final class OrderScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void normalize(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        CatalogEvaluator.translate(value);
    }
}
