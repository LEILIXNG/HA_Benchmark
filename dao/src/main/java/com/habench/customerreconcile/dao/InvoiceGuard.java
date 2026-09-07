package com.habench.customerreconcile.dao;

import com.habench.customerreconcile.dao.ShipmentRepository;
import java.util.regex.Pattern;

public final class InvoiceGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void attach(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ShipmentRepository.reconcile(value);
    }
}
