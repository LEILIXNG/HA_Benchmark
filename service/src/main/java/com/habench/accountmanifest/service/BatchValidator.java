package com.habench.accountmanifest.service;

import com.habench.accountmanifest.service.InvoiceLoader;
import java.util.regex.Pattern;

public final class BatchValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void reconcile(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        InvoiceLoader.publish(value);
    }
}
