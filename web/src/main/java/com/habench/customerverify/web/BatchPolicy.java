package com.habench.customerverify.web;

import com.habench.customerverify.web.ShipmentRegistry;
import java.util.regex.Pattern;

public final class BatchPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ShipmentRegistry.refine(value);
    }
}
