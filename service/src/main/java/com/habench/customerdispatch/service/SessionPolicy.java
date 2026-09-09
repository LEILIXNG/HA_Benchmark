package com.habench.customerdispatch.service;

import com.habench.customerdispatch.service.TariffEnricher;
import java.util.regex.Pattern;

public final class SessionPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffEnricher.submit(value);
    }
}
