package com.habench.reporthold.service;

import com.habench.reporthold.service.ContractEvaluator;
import java.util.regex.Pattern;

public final class InvoicePolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void prepare(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractEvaluator.attach(value);
    }
}
