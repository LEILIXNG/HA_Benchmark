package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.PaymentTranslator;
import java.util.regex.Pattern;

public final class TariffScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        PaymentTranslator.merge(value);
    }
}
