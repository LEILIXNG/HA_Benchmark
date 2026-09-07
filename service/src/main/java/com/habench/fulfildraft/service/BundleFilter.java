package com.habench.fulfildraft.service;

import com.habench.fulfildraft.service.PaymentEvaluator;
import java.util.regex.Pattern;

public final class BundleFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        PaymentEvaluator.prepare(value);
    }
}
