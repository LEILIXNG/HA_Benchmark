package com.habench.shippingarchive.service;

import com.habench.shippingarchive.service.SessionLoader;
import java.util.regex.Pattern;

public final class LedgerGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionLoader.submit(value);
    }
}
