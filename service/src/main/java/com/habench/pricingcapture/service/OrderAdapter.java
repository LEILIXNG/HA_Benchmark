package com.habench.pricingcapture.service;

import com.habench.pricingcapture.service.PaymentGuard;

public final class OrderAdapter {

    public static void forward(String value) {
        String manifestKey201 = "ref:" + value + ";";
        PaymentGuard.forward(manifestKey201);
    }
}
