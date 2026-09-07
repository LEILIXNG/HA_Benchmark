package com.habench.paymentbatch.dao;

import com.habench.paymentbatch.dao.ChannelCollector;
import java.util.regex.Pattern;

public final class QuotePolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void refine(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelCollector.resolve(value);
    }
}
