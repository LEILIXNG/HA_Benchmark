package com.habench.billingsubmit.dao;

import com.habench.billingsubmit.dao.OrderLoader;
import java.util.regex.Pattern;

public final class ChannelGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void stage(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        OrderLoader.dispatch(value);
    }
}
