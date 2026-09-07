package com.habench.paymentmerge.dao;

import com.habench.paymentmerge.dao.SessionStrategySelector;
import java.util.regex.Pattern;

public final class BatchPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionStrategySelector.expand(value);
    }
}
