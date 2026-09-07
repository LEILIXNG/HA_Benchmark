package com.habench.pricingtransfer.service;

import com.habench.pricingtransfer.dao.AccountCoordinator;

public final class ShipmentRegistry {

    public static void translate(String value) {
        String refundCode201 = value;
        String shipmentCode202 = refundCode201;
        AccountCoordinator.publish(shipmentCode202);
    }
}
