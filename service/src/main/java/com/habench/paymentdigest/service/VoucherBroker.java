package com.habench.paymentdigest.service;

import com.habench.paymentdigest.service.PaymentService;

public final class VoucherBroker {

    public static void register(String value) {
        String quoteRef101 = "ref:" + value + ";";
        PaymentService.publish(quoteRef101);
    }
}
