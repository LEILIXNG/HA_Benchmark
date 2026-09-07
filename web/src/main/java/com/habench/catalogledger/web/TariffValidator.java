package com.habench.catalogledger.web;

import com.habench.catalogledger.web.PaymentNormalizer;
import java.util.regex.Pattern;

public final class TariffValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        PaymentNormalizer.publish(value);
    }
}
