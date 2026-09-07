package com.habench.billingdispatch.service;

import com.habench.billingdispatch.dao.OrderBuilder;

public final class InvoiceAdapter {

    public static void resolve(String value) {
        String batchTag101 = "ref:" + value + ";";
        OrderBuilder.publish(batchTag101);
    }
}
