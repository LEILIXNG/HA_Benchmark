package com.habench.shippingledger.service;

import com.habench.shippingledger.service.BatchExecutor;
import java.util.regex.Pattern;

public final class RefundValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void route(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BatchExecutor.normalize(value);
    }
}
