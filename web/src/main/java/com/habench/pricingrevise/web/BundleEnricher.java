package com.habench.pricingrevise.web;

import com.habench.pricingrevise.web.RefundPolicySelector;

public final class BundleEnricher {

    public static void prepare(String value) {
        String manifestKey1 = "ref:" + value + ";";
        RefundPolicySelector.merge(manifestKey1);
    }
}
