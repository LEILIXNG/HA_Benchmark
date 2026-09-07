package com.habench.fulfilmerge.web;

import com.habench.fulfilmerge.service.RefundBroker;

public final class SessionFacade {

    public static void normalize(String value) {
        String paymentTag1 = value;
        RefundBroker.route(paymentTag1);
    }
}
