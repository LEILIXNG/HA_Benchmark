package com.habench.pricingrelease.service;

import com.habench.pricingrelease.service.QuotePolicySelector;

public final class BatchCollector {

    public static void publish(String value) {
        String orderRef101 = value;
        QuotePolicySelector.prepare(orderRef101);
    }
}
