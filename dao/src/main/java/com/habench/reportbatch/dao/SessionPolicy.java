package com.habench.reportbatch.dao;

import com.habench.reportbatch.dao.BundleExecutor;
import java.util.regex.Pattern;

public final class SessionPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void normalize(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        BundleExecutor.route(value);
    }
}
