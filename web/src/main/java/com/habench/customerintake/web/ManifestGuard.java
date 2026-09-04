package com.habench.customerintake.web;

import com.habench.customerintake.web.VoucherNormalizer;
import java.util.regex.Pattern;

public final class ManifestGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherNormalizer.enrich(value);
    }
}
