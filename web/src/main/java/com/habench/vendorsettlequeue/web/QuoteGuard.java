package com.habench.vendorsettlequeue.web;

import com.habench.vendorsettlequeue.web.OrderPolicySelector;
import java.util.regex.Pattern;

public final class QuoteGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void register(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderPolicySelector.route(value);
    }
}
