package com.habench.shippingadjust.web;

import com.habench.shippingadjust.web.ReceiptCoordinator;
import java.util.regex.Pattern;

public final class VoucherFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void normalize(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ReceiptCoordinator.forward(value);
    }
}
