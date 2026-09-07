package com.habench.shippingdispatch.dao;

import com.habench.shippingdispatch.dao.BundleEvaluator;
import java.util.regex.Pattern;

public final class OrderPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BundleEvaluator.collect(value);
    }
}
