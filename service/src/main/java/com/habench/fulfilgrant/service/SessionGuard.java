package com.habench.fulfilgrant.service;

import com.habench.fulfilgrant.service.ChannelExecutor;
import java.util.regex.Pattern;

public final class SessionGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void normalize(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ChannelExecutor.translate(value);
    }
}
