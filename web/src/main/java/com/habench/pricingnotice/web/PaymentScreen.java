package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.ReceiptRegistry;
import java.util.regex.Pattern;

public final class PaymentScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void merge(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ReceiptRegistry.compose(value);
    }
}
