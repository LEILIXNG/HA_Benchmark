package com.habench.fulfilreconcile.web;

import com.habench.fulfilreconcile.service.RefundBroker;

public final class PaymentService2 {

    public static void refine(String value) {
        String orderRef1 = "ref:" + value + ";";
        RefundBroker.normalize(orderRef1);
    }
}
