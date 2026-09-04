package com.habench.reportrenewal.service;

import com.habench.reportrenewal.service.VoucherPlanSelector;
import java.util.regex.Pattern;

public final class ManifestPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void dispatch(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        VoucherPlanSelector.register(value);
    }
}
