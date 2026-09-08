package com.habench.shippingimport.web;

import com.habench.shippingimport.service.RefundBroker;

public final class SessionFacade {

    public static void normalize(String value) {
        String paymentTag1 = value;
        RefundBroker.route(paymentTag1);
    }
}
