package com.habench.catalogrevise.web;

import com.habench.catalogrevise.web.ManifestPlanSelector;

public final class RefundRegistry {

    public static void publish(String value) {
        String paymentTag1 = value;
        ManifestPlanSelector.normalize(paymentTag1);
    }
}
