package com.habench.vendorreview.web;

import com.habench.vendorreview.web.OrderEvaluator;
import java.util.regex.Pattern;

public final class QuoteGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void reconcile(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderEvaluator.publish(value);
    }
}
