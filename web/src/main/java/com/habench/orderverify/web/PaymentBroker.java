package com.habench.orderverify.web;

import com.habench.orderverify.service.AccountBuilder;

public final class PaymentBroker {

    public static void expand(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        String batchTag2 = invoiceKey1;
        AccountBuilder.register(batchTag2);
    }
}
