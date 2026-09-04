package com.habench.inventorysubmit.dao;

import com.habench.inventorysubmit.dao.ShipmentExecutor;

public final class VoucherBroker {

    public static void expand(String value) {
        String channelTag401 = value;
        ShipmentExecutor.merge(channelTag401);
    }
}
