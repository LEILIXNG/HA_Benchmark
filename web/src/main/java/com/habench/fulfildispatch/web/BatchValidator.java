package com.habench.fulfildispatch.web;

import com.habench.fulfildispatch.web.BundleCollector;
import java.util.regex.Pattern;

public final class BatchValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BundleCollector.route(value);
    }
}
