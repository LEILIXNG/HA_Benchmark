package com.habench.billingreopen.dao;

import com.habench.billingreopen.dao.LedgerExecutor;
import java.util.regex.Pattern;

public final class ContractFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void expand(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        LedgerExecutor.register(value);
    }
}
