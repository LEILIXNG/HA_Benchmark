package com.habench.billingreconcile.web;

import com.habench.billingreconcile.web.RefundStrategySelector;

public final class OrderResolver {

    public static void translate(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        String batchTag2 = invoiceKey1;
        RefundStrategySelector.publish(batchTag2);
    }
}
