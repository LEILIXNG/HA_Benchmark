package com.habench.pricingtransfer.service;

import com.habench.pricingtransfer.service.ShipmentRuleSelector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ManifestPolicy {
    private static final Set<String> PERMITTED =
            new HashSet<String>(Arrays.asList("status", "version", "uptime"));

    public static void dispatch(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ShipmentRuleSelector.assemble(value);
    }
}
