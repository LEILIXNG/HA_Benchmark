package com.habench.shippingrevise.web;

import com.habench.shippingrevise.web.QuoteNormalizer;

public final class ShipmentResolver {
    private static String cachedOrder;

    public static void forward(String value) {
        String voucherRef101 = "ref:" + value + ";";
        cachedOrder = voucherRef101;
        translate();
    }

    private static void translate() {
        String paymentTag102 = cachedOrder;
        String refundCode103 = "ref:" + paymentTag102 + ";";
        QuoteNormalizer.attach(refundCode103);
    }
}
