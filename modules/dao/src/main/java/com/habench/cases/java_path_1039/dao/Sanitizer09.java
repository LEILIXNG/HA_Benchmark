package com.habench.cases.java_path_1039.dao;

import com.habench.cases.java_path_1039.dao.Step09;
import java.util.regex.Pattern;

public final class Sanitizer09 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        Step09.apply(value);
    }
}
