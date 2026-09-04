package com.habench.cases.java_path_1007_n.service;

import com.habench.cases.java_path_1007_n.service.SinkHandler;
import java.util.regex.Pattern;

public final class Sanitizer02 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SinkHandler.execute(value);
    }
}
