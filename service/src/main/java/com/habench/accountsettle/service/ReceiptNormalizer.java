package com.habench.accountsettle.service;

import com.habench.accountsettle.dao.PaymentCollector;

public final class ReceiptNormalizer {

    public static void compose(String value) {
        String paymentTag101 = "ref:" + value + ";";
        PaymentCollector.register(paymentTag101);
    }
}
