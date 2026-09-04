package com.habench.paymentrollup.dao;

import com.habench.paymentrollup.dao.BundleLoader;
import java.util.regex.Pattern;

public final class ShipmentScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void resolve(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BundleLoader.expand(value);
    }
}
