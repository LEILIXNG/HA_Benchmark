package com.habench.accountreconcile.service;

import com.habench.accountreconcile.service.BatchExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ChannelPolicy {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void route(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        BatchExecutor.merge(value);
    }
}
