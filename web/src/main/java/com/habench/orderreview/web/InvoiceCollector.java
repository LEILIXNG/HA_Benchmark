package com.habench.orderreview.web;

import com.habench.orderreview.web.ChannelAssembler;

public final class InvoiceCollector {
    private static String cachedPayment;

    public static void route(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = voucherRef101;
        cachedPayment = paymentTag102;
        submit();
    }

    private static void submit() {
        String refundCode103 = cachedPayment;
        String shipmentCode104 = "ref:" + refundCode103 + ";";
        ChannelAssembler.publish(shipmentCode104);
    }
}
