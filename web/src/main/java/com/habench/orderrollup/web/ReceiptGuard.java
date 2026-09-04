package com.habench.orderrollup.web;

import com.habench.orderrollup.web.ChannelRouter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ReceiptGuard {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void refine(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ChannelRouter.merge(value);
    }
}
