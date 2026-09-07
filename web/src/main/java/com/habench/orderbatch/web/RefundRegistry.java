package com.habench.orderbatch.web;

import com.habench.orderbatch.web.InvoiceCollector;

public final class RefundRegistry {

    public static void forward(String value) {
        String paymentTag1 = value;
        String refundCode2 = paymentTag1;
        InvoiceCollector.stage(refundCode2);
    }
}
