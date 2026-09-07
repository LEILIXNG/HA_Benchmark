package com.habench.pricingmerge.web;

import com.habench.pricingmerge.web.ManifestLoader;
import java.util.regex.Pattern;

public final class SessionFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void attach(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestLoader.collect(value);
    }
}
