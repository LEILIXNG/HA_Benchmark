package com.habench.catalogreopen.service;

import com.habench.catalogreopen.service.OrderEvaluator;
import java.util.regex.Pattern;

public final class SessionPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void assemble(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderEvaluator.register(value);
    }
}
