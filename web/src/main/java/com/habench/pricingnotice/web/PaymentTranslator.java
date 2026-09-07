package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.AccountCollector;

public final class PaymentTranslator {

    public static void merge(String value) {
        String batchTag101 = "ref:" + value + ";";
        String orderRef102 = "ref:" + batchTag101 + ";";
        AccountCollector.merge(orderRef102);
    }
}
