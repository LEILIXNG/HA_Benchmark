package com.habench.cases.java_path_1028.dao;

import com.habench.cases.java_path_1028.dao.Gateway08;
import java.util.regex.Pattern;

public final class Sanitizer08 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        Gateway08.apply(value);
    }
}
