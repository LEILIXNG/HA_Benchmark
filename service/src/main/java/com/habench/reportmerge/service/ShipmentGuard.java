package com.habench.reportmerge.service;

import com.habench.reportmerge.service.SessionExecutor;
import java.util.regex.Pattern;

public final class ShipmentGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void route(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionExecutor.route(value);
    }
}
