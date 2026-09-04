package com.habench.fulfilreconcile.web;

import com.habench.fulfilreconcile.service.RefundBroker;

public final class PaymentService2 {

    public static void refine(String value) {
        String paymentTag1 = "ref:" + value + ";";
        RefundBroker.normalize(paymentTag1);
    }
}
