package com.habench.path1024n.service;

import com.habench.path1024n.service.Stage03;
import java.util.regex.Pattern;

public final class Sanitizer03 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        Stage03.apply(value);
    }
}
