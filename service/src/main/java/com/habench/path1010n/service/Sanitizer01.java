package com.habench.path1010n.service;

import com.habench.path1010n.service.Stage01;
import java.util.regex.Pattern;

public final class Sanitizer01 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        Stage01.handle(value);
    }
}
