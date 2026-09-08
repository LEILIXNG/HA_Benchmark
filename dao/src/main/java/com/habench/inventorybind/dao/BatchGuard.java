package com.habench.inventorybind.dao;

import com.habench.inventorybind.dao.ContractGateway;
import java.util.regex.Pattern;

public final class BatchGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void merge(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractGateway.route(value);
    }
}
