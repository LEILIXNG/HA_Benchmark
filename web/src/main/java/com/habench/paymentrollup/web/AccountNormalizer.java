package com.habench.paymentrollup.web;

import com.habench.paymentrollup.service.PaymentCollector;

public final class AccountNormalizer {

    public static void register(String value) {
        PaymentCollector.expand(value);
    }
}
