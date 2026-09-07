package com.habench.customermerge.service;

import com.habench.customermerge.service.AccountExecutor;
import java.util.regex.Pattern;

public final class PaymentGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        AccountExecutor.normalize(value);
    }
}
