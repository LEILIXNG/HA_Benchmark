package com.habench.reportmanifest.web;

import com.habench.reportmanifest.web.ContractExecutor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class BundleValidator {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void attach(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ContractExecutor.refine(value);
    }
}
