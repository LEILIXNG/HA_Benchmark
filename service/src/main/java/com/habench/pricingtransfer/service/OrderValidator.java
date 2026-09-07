package com.habench.pricingtransfer.service;

import com.habench.pricingtransfer.service.AccountRepository;
import java.util.regex.Pattern;

public final class OrderValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void submit(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        AccountRepository.compose(value);
    }
}
