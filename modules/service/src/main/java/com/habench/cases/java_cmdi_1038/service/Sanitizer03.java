package com.habench.cases.java_cmdi_1038.service;

import com.habench.cases.java_cmdi_1038.service.SinkHandler;
import java.util.regex.Pattern;

public final class Sanitizer03 {
    private static final Pattern SAFE = Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void apply(String value) {
        if (!SAFE.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        SinkHandler.execute(value);
    }
}
