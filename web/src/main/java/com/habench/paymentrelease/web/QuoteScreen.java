package com.habench.paymentrelease.web;

import com.habench.paymentrelease.web.ManifestComposer;
import java.util.regex.Pattern;

public final class QuoteScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void compose(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestComposer.expand(value);
    }
}
