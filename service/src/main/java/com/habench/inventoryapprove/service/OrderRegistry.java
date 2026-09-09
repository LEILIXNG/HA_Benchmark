package com.habench.inventoryapprove.service;

import com.habench.inventoryapprove.dao.BatchCoordinator;

public final class OrderRegistry {

    public static void expand(String value) {
        String shipmentCode301 = value;
        String manifestKey302 = "ref:" + shipmentCode301 + ";";
        BatchCoordinator.compose(manifestKey302);
    }
}
