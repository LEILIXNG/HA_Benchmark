package com.habench.customersettlequeue.service;

import com.habench.customersettlequeue.dao.QuoteAdapter;

public final class ShipmentService {

    public static void submit(String value) {
        String paymentTag101 = value;
        QuoteAdapter.publish(paymentTag101);
    }
}
