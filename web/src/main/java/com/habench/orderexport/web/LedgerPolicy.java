package com.habench.orderexport.web;

import com.habench.orderexport.web.ChannelExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class LedgerPolicy {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void route(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ChannelExecutor.assemble(value);
    }
}
