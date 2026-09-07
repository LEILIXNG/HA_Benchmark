package com.habench.catalogbind.dao;

import com.habench.catalogbind.dao.TariffEvaluator;
import java.util.regex.Pattern;

public final class InvoiceValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void attach(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffEvaluator.prepare(value);
    }
}
