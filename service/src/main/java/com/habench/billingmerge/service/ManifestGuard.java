package com.habench.billingmerge.service;

import com.habench.billingmerge.service.SessionNormalizer;
import java.util.regex.Pattern;

public final class ManifestGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void dispatch(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionNormalizer.translate(value);
    }
}
