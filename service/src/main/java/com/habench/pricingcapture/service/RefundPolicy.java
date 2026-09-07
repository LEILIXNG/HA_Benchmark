package com.habench.pricingcapture.service;

import com.habench.pricingcapture.service.ManifestBuilder;
import java.util.regex.Pattern;

public final class RefundPolicy {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void dispatch(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestBuilder.forward(value);
    }
}
