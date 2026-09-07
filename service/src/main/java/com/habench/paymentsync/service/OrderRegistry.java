package com.habench.paymentsync.service;

import com.habench.paymentsync.service.ShipmentExecutor;

public final class OrderRegistry {

    public static void collect(String value) {
        String receiptKey201 = "ref:" + value + ";";
        ShipmentExecutor.route(receiptKey201);
    }
}
