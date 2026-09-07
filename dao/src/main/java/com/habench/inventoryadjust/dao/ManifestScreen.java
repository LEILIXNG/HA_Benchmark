package com.habench.inventoryadjust.dao;

import com.habench.inventoryadjust.dao.VoucherExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ManifestScreen {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void resolve(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        VoucherExecutor.dispatch(value);
    }
}
