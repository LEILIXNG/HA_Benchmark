package com.habench.vendorreconcile.service;

import com.habench.vendorreconcile.service.ContractResolver;
import java.util.regex.Pattern;

public final class RefundFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void expand(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractResolver.compose(value);
    }
}
