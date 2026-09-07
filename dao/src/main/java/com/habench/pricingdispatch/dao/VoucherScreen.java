package com.habench.pricingdispatch.dao;

import com.habench.pricingdispatch.dao.OrderLoader;
import java.util.regex.Pattern;

public final class VoucherScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void register(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderLoader.translate(value);
    }
}
