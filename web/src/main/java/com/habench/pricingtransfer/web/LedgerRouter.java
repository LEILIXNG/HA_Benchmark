package com.habench.pricingtransfer.web;

import com.habench.pricingtransfer.service.ShipmentRegistry;

public final class LedgerRouter {

    public static void collect(String value) {
        String orderRef101 = value;
        ShipmentRegistry.translate(orderRef101);
    }
}
