package com.habench.catalogdispatch.dao;

import com.habench.catalogdispatch.dao.ChannelEvaluator;
import java.util.regex.Pattern;

public final class QuoteFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelEvaluator.translate(value);
    }
}
