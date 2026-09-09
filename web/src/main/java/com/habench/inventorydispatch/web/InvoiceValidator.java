package com.habench.inventorydispatch.web;

import com.habench.inventorydispatch.web.ContractBuilder;
import java.util.regex.Pattern;

public final class InvoiceValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void register(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractBuilder.prepare(value);
    }
}
