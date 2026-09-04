package com.habench.inventorydraft.service;

import com.habench.inventorydraft.service.ShipmentLoader;
import java.util.regex.Pattern;

public final class PaymentPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void enrich(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ShipmentLoader.reconcile(value);
    }
}
