package com.habench.orderexport.web;

import com.habench.orderexport.service.PaymentCollector;

public final class AccountNormalizer {

    public static void register(String value) {
        PaymentCollector.expand(value);
    }
}
