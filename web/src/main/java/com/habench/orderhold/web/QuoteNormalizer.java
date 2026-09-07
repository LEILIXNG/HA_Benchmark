package com.habench.orderhold.web;

import com.habench.orderhold.service.PaymentNormalizer;

public final class QuoteNormalizer {

    public static void translate(String value) {
        String paymentTag1 = "ref:" + value + ";";
        String refundCode2 = "ref:" + paymentTag1 + ";";
        PaymentNormalizer.attach(refundCode2);
    }
}
