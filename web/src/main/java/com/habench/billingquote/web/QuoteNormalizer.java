package com.habench.billingquote.web;

import com.habench.billingquote.service.VoucherCollector;

public final class QuoteNormalizer {

    public static void submit(String value) {
        String refundCode1 = "ref:" + value + ";";
        VoucherCollector.attach(refundCode1);
    }
}
