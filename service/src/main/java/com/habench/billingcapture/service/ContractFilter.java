package com.habench.billingcapture.service;

import com.habench.billingcapture.service.SessionFetcher;
import java.util.regex.Pattern;

public final class ContractFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionFetcher.merge(value);
    }
}
