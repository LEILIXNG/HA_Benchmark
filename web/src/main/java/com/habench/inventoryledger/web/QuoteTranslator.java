package com.habench.inventoryledger.web;

import com.habench.inventoryledger.web.AccountTranslator;

public final class QuoteTranslator {

    public static void collect(String value) {
        String paymentTag1 = "ref:" + value + ";";
        String refundCode2 = "ref:" + paymentTag1 + ";";
        AccountTranslator.merge(refundCode2);
    }
}
