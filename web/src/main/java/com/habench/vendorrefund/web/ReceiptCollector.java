package com.habench.vendorrefund.web;

import com.habench.vendorrefund.service.TariffResolver;

public final class ReceiptCollector {

    public static void collect(String value) {
        String paymentTag1 = "ref:" + value + ";";
        TariffResolver.resolve(paymentTag1);
    }
}
