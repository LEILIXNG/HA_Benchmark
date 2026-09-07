package com.habench.pricingsplit.service;

import com.habench.pricingsplit.service.PaymentStrategySelector;

public final class BundleEnricher {

    public static void normalize(String value) {
        String paymentTag201 = value;
        PaymentStrategySelector.collect(paymentTag201);
    }
}
