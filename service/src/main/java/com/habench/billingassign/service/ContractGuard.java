package com.habench.billingassign.service;

import com.habench.billingassign.service.TariffLoader;
import java.util.regex.Pattern;

public final class ContractGuard {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void reconcile(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffLoader.translate(value);
    }
}
