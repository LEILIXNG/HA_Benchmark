package com.habench.catalogquote.service;

import com.habench.catalogquote.service.BatchRepository;
import java.util.regex.Pattern;

public final class AccountScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void register(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BatchRepository.translate(value);
    }
}
