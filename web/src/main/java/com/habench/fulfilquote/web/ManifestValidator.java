package com.habench.fulfilquote.web;

import com.habench.fulfilquote.web.QuotePlanSelector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ManifestValidator {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void assemble(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        QuotePlanSelector.translate(value);
    }
}
