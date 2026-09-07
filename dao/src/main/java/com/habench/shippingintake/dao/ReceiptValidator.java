package com.habench.shippingintake.dao;

import com.habench.shippingintake.dao.InvoiceEvaluator;
import java.util.regex.Pattern;

public final class ReceiptValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void reconcile(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        InvoiceEvaluator.dispatch(value);
    }
}
