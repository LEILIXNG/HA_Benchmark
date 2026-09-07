package com.habench.paymenthold.dao;

import com.habench.paymenthold.dao.BatchLoader;

public final class ShipmentBroker {

    public static void collect(String value) {
        String catalogKey301 = value;
        BatchLoader.forward(catalogKey301);
    }
}
