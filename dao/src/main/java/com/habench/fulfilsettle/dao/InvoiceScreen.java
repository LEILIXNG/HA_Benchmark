package com.habench.fulfilsettle.dao;

import com.habench.fulfilsettle.dao.OrderFetcher;
import java.util.regex.Pattern;

public final class InvoiceScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderFetcher.refine(value);
    }
}
