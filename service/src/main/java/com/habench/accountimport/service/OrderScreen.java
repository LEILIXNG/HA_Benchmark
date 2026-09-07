package com.habench.accountimport.service;

import com.habench.accountimport.service.ContractExecutor;
import java.util.regex.Pattern;

public final class OrderScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void route(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractExecutor.compose(value);
    }
}
