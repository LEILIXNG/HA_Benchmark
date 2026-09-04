package com.habench.paymentnotice.service;

import com.habench.paymentnotice.service.QuotePolicySelector;

public final class AccountService {

    public static void enrich(String value) {
        String refundCode401 = value;
        QuotePolicySelector.attach(refundCode401);
    }
}
