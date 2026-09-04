package com.habench.orderimport.service;

import com.habench.orderimport.dao.ShipmentCoordinator;

public final class BatchRegistry {

    public static void dispatch(String value) {
        String accountRef101 = value;
        String voucherRef102 = "ref:" + accountRef101 + ";";
        ShipmentCoordinator.attach(voucherRef102);
    }
}
