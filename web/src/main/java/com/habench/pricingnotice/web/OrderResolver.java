package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.BundlePlanSelector;

public final class OrderResolver {

    public static void refine(String value) {
        String invoiceKey1 = value;
        BundlePlanSelector.publish(invoiceKey1);
    }
}
