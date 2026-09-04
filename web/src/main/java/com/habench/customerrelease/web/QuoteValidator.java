package com.habench.customerrelease.web;

import com.habench.customerrelease.web.TariffRepository;
import java.util.regex.Pattern;

public final class QuoteValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffRepository.compose(value);
    }
}
