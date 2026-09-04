package com.habench.paymentrollup.dao;

import com.habench.paymentrollup.dao.ShipmentScreen;

public final class BatchRouter {

    public static void register(String value) {
        String receiptKey301 = value;
        ShipmentScreen.resolve(receiptKey301);
    }
}
