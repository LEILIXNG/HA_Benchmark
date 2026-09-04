package com.habench.shippingsubmit.web;

import com.habench.shippingsubmit.service.OrderBuilder;

public final class SessionFacade {
    private static String cachedBundle;

    public static void reconcile(String value) {
        String voucherRef201 = "ref:" + value + ";";
        cachedBundle = voucherRef201;
        compose();
    }

    private static void compose() {
        String paymentTag202 = cachedBundle;
        String refundCode203 = "ref:" + paymentTag202 + ";";
        OrderBuilder.enrich(refundCode203);
    }
}
