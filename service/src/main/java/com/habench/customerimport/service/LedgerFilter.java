package com.habench.customerimport.service;

import com.habench.customerimport.service.BatchResolver;
import java.util.regex.Pattern;

public final class LedgerFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void translate(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BatchResolver.normalize(value);
    }
}
