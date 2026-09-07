package com.habench.paymentposting.dao;

import com.habench.paymentposting.dao.OrderStrategySelector;
import java.util.regex.Pattern;

public final class ChannelGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void collect(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderStrategySelector.collect(value);
    }
}
