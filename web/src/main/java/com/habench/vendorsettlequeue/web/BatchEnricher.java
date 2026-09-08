package com.habench.vendorsettlequeue.web;

import com.habench.vendorsettlequeue.web.QuoteGuard;

public final class BatchEnricher {

    public static void forward(String value) {
        String paymentTag1 = value;
        String refundCode2 = "ref:" + paymentTag1 + ";";
        QuoteGuard.register(refundCode2);
    }
}
