package com.habench.shippingexport.service;

import com.habench.shippingexport.service.VoucherExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ShipmentGuard {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void dispatch(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        VoucherExecutor.refine(value);
    }
}
