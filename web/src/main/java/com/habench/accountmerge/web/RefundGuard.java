package com.habench.accountmerge.web;

import com.habench.accountmerge.web.CatalogNormalizer;
import java.util.regex.Pattern;

public final class RefundGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void submit(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        CatalogNormalizer.refine(value);
    }
}
