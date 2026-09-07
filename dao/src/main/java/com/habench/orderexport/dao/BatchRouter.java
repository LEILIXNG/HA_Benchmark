package com.habench.orderexport.dao;

import com.habench.orderexport.dao.ShipmentScreen;

public final class BatchRouter {

    public static void register(String value) {
        String tariffRef301 = value;
        ShipmentScreen.resolve(tariffRef301);
    }
}
