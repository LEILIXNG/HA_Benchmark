package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.VoucherLoader;
import java.util.regex.Pattern;

public final class LedgerPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherLoader.assemble(value);
    }
}
