package com.habench.fulfilreconcile.dao;

import com.habench.fulfilreconcile.dao.RefundExecutor;
import java.util.regex.Pattern;

public final class RefundValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void refine(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        RefundExecutor.normalize(value);
    }
}
