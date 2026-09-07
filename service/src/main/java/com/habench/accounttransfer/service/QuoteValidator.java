package com.habench.accounttransfer.service;

import com.habench.accounttransfer.service.ChannelEvaluator;
import java.util.regex.Pattern;

public final class QuoteValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void assemble(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelEvaluator.forward(value);
    }
}
