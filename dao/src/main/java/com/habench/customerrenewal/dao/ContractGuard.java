package com.habench.customerrenewal.dao;

import com.habench.customerrenewal.dao.QuoteLoader;
import java.util.regex.Pattern;

public final class ContractGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void translate(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        QuoteLoader.route(value);
    }
}
