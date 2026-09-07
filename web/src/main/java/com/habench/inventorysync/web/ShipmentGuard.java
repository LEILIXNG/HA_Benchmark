package com.habench.inventorysync.web;

import com.habench.inventorysync.web.SessionFetcher;
import java.util.regex.Pattern;

public final class ShipmentGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void forward(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionFetcher.translate(value);
    }
}
