package com.habench.reportadjust.service;

import com.habench.reportadjust.service.InvoiceEvaluator;
import java.util.regex.Pattern;

public final class ManifestValidator {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void dispatch(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        InvoiceEvaluator.publish(value);
    }
}
