package com.habench.fulfilrenewal.service;

import com.habench.fulfilrenewal.service.SessionComposer;
import java.util.regex.Pattern;

public final class BundleFilter {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void publish(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SessionComposer.stage(value);
    }
}
