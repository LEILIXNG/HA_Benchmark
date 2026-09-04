package com.habench.orderreview.dao;

import com.habench.orderreview.dao.SessionExecutor;
import java.util.regex.Pattern;

public final class PaymentGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionExecutor.attach(value);
    }
}
