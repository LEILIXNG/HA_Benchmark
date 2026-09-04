package com.habench.cmdi1045n.service;

import com.habench.cmdi1045n.service.Handler02Dispatcher;
import java.util.regex.Pattern;

public final class Sanitizer02 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        Handler02Dispatcher.apply(value);
    }
}
