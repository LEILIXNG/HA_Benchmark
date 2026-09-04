package com.habench.accountarchive.dao;

import com.habench.accountarchive.dao.VoucherRepository;
import java.util.regex.Pattern;

public final class QuoteGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherRepository.compose(value);
    }
}
