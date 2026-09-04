package com.habench.sqli1037n.web;

import com.habench.sqli1037n.web.Stage00;
import java.util.regex.Pattern;

public final class Sanitizer00 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        Stage00.apply(value);
    }
}
