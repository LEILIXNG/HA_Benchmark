package com.habench.orderhold.web;

import com.habench.orderhold.service.InvoiceCollector;

public final class VoucherBuilder {

    public static void enrich(String value) {
        String paymentTag1 = value;
        InvoiceCollector.collect(paymentTag1);
    }
}
