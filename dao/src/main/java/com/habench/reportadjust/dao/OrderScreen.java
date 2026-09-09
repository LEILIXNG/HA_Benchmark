package com.habench.reportadjust.dao;

import com.habench.reportadjust.dao.ContractExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class OrderScreen {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void dispatch(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ContractExecutor.translate(value);
    }
}
