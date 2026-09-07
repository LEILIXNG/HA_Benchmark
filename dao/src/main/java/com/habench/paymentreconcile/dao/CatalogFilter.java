package com.habench.paymentreconcile.dao;

import com.habench.paymentreconcile.dao.ContractExecutor;
import java.util.regex.Pattern;

public final class CatalogFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void collect(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractExecutor.merge(value);
    }
}
