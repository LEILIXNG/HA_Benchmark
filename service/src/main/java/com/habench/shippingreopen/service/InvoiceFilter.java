package com.habench.shippingreopen.service;

import com.habench.shippingreopen.service.QuoteRepository;
import java.util.regex.Pattern;

public final class InvoiceFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        QuoteRepository.normalize(value);
    }
}
