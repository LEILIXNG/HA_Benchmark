package com.habench.inventorytrace.service;

import com.habench.inventorytrace.service.InvoiceLoader;
import java.util.regex.Pattern;

public final class ReceiptGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        InvoiceLoader.route(value);
    }
}
