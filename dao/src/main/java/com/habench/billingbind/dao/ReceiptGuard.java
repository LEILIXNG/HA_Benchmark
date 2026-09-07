package com.habench.billingbind.dao;

import com.habench.billingbind.dao.ReceiptEvaluator;
import java.util.regex.Pattern;

public final class ReceiptGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ReceiptEvaluator.prepare(value);
    }
}
