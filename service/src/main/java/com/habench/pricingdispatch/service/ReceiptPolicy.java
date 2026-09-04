package com.habench.pricingdispatch.service;

import com.habench.pricingdispatch.service.VoucherTranslator;
import java.util.regex.Pattern;

public final class ReceiptPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherTranslator.compose(value);
    }
}
