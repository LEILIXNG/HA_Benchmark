package com.habench.paymentrollup.dao;

import com.habench.paymentrollup.dao.ShipmentScreen;

public final class BatchRouter {

    public static void register(String value) {
        String tariffRef301 = value;
        ShipmentScreen.resolve(tariffRef301);
    }
}
