package com.habench.ordersettle.web;

import com.habench.ordersettle.service.ChannelRegistry;

public final class QuoteAssembler {
    private static String cachedPayment;

    public static void normalize(String value) {
        String paymentTag1 = "ref:" + value + ";";
        cachedPayment = paymentTag1;
        reconcile();
    }

    private static void reconcile() {
        String refundCode2 = cachedPayment;
        String shipmentCode3 = refundCode2;
        String manifestKey4 = shipmentCode3;
        ChannelRegistry.refine(manifestKey4);
    }
}
