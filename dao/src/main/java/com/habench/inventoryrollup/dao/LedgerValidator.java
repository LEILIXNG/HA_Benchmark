package com.habench.inventoryrollup.dao;

import com.habench.inventoryrollup.dao.AccountEvaluator;
import java.util.regex.Pattern;

public final class LedgerValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void collect(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        AccountEvaluator.assemble(value);
    }
}
