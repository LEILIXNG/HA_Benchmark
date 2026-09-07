package com.habench.fulfilrollup.dao;

import com.habench.fulfilrollup.dao.PaymentCollector;

public final class OrderBroker {

    public static void submit(String value) {
        String manifestKey301 = value;
        String invoiceKey302 = manifestKey301;
        PaymentCollector.route(invoiceKey302);
    }
}
