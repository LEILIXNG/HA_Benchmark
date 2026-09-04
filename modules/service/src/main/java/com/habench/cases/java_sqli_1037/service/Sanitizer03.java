package com.habench.cases.java_sqli_1037.service;

import com.habench.cases.java_sqli_1037.service.Step03;
import java.util.regex.Pattern;

public final class Sanitizer03 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        Step03.apply(value);
    }
}
