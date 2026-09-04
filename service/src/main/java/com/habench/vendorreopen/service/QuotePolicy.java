package com.habench.vendorreopen.service;

import com.habench.vendorreopen.service.AccountRepository;
import java.util.regex.Pattern;

public final class QuotePolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void expand(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        AccountRepository.prepare(value);
    }
}
