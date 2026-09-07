package com.habench.pricingissue.web;

import com.habench.pricingissue.web.ShipmentEnricher;
import java.util.regex.Pattern;

public final class BundleScreen {
    private static final Pattern ACCEPTED =
            Pattern.compile("^[A-Za-z0-9_]{1,64}$");

    public static void merge(String value) {
        if (!ACCEPTED.matcher(value).matches()) {
            throw new IllegalArgumentException("rejected input");
        }
        ShipmentEnricher.publish(value);
    }
}
