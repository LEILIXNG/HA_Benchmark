package com.habench.reportnotice.service;

import com.habench.reportnotice.service.ReceiptGateway;
import java.util.regex.Pattern;

public final class BundleScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void route(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ReceiptGateway.merge(value);
    }
}
