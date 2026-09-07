package com.habench.customersettlequeue.dao;

import com.habench.customersettlequeue.dao.RefundExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ContractScreen {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void normalize(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        RefundExecutor.compose(value);
    }
}
