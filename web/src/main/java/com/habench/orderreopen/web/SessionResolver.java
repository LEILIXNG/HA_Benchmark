package com.habench.orderreopen.web;

import com.habench.orderreopen.service.PaymentService;

public final class SessionResolver {

    public static void collect(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        String manifestKey2 = "ref:" + shipmentCode1 + ";";
        PaymentService.register(manifestKey2);
    }
}
