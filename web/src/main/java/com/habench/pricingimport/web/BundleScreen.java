package com.habench.pricingimport.web;

import com.habench.pricingimport.web.VoucherLoader;
import java.util.regex.Pattern;

public final class BundleScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherLoader.enrich(value);
    }
}
