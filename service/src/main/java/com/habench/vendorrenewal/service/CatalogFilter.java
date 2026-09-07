package com.habench.vendorrenewal.service;

import com.habench.vendorrenewal.service.QuoteRepository;
import java.util.regex.Pattern;

public final class CatalogFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        QuoteRepository.dispatch(value);
    }
}
