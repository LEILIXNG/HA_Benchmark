package com.habench.accountdigest.service;

import com.habench.accountdigest.service.PaymentLoader;
import java.util.regex.Pattern;

public final class ManifestScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void refine(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        PaymentLoader.collect(value);
    }
}
