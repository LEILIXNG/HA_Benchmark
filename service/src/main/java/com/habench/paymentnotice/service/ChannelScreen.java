package com.habench.paymentnotice.service;

import com.habench.paymentnotice.service.CatalogRepository;
import java.util.regex.Pattern;

public final class ChannelScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        CatalogRepository.merge(value);
    }
}
