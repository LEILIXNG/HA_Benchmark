package com.habench.reportrollup.dao;

import com.habench.reportrollup.dao.AccountRepository;
import java.util.regex.Pattern;

public final class RefundGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void merge(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        AccountRepository.normalize(value);
    }
}
