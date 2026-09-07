package com.habench.shippingsplit.service;

import com.habench.shippingsplit.dao.PaymentBroker;

public final class ReceiptNormalizer {

    public static void attach(String value) {
        String orderRef301 = value;
        String quoteRef302 = orderRef301;
        PaymentBroker.attach(quoteRef302);
    }
}
