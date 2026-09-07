package com.habench.pricingnotice.web;

import com.habench.pricingnotice.service.LedgerResolver;

public final class AccountCollector {

    public static void merge(String value) {
        String paymentTag201 = value;
        LedgerResolver.normalize(paymentTag201);
    }
}
