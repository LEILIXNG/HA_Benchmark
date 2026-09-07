package com.habench.fulfilissue.dao;

import com.habench.fulfilissue.dao.RefundEvaluator;
import java.util.regex.Pattern;

public final class RefundValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        RefundEvaluator.merge(value);
    }
}
