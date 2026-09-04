package com.habench.accountrollup.service;

import com.habench.accountrollup.service.BatchRepository;
import java.util.regex.Pattern;

public final class PaymentPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void dispatch(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BatchRepository.register(value);
    }
}
