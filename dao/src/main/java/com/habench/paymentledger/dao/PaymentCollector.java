package com.habench.paymentledger.dao;

import com.habench.paymentledger.dao.TariffLoader;

public final class PaymentCollector {

    public static void enrich(String value) {
        String paymentTag401 = "ref:" + value + ";";
        String refundCode402 = "ref:" + paymentTag401 + ";";
        TariffLoader.translate(refundCode402);
    }
}
