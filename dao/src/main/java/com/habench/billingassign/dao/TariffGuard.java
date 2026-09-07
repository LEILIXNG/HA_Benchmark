package com.habench.billingassign.dao;

import com.habench.billingassign.dao.SessionExecutor;
import java.util.regex.Pattern;

public final class TariffGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void merge(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionExecutor.assemble(value);
    }
}
