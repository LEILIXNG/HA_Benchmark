package com.habench.catalogrollup.web;

import com.habench.catalogrollup.web.ContractExecutor;
import java.util.regex.Pattern;

public final class AccountPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractExecutor.prepare(value);
    }
}
