package com.habench.pricingissue.dao;

import com.habench.pricingissue.dao.LedgerRepository;
import java.util.regex.Pattern;

public final class SessionScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void merge(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        LedgerRepository.prepare(value);
    }
}
