package com.habench.reportsettle.service;

import com.habench.reportsettle.service.QuoteCoordinator;
import java.util.regex.Pattern;

public final class VoucherValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        QuoteCoordinator.forward(value);
    }
}
