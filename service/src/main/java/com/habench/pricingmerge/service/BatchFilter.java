package com.habench.pricingmerge.service;

import com.habench.pricingmerge.service.TariffCollector;
import java.util.regex.Pattern;

public final class BatchFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void reconcile(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffCollector.prepare(value);
    }
}
