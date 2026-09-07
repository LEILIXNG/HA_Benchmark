package com.habench.shippingarchive.web;

import com.habench.shippingarchive.service.ShipmentCoordinator;

public final class CatalogCollector {

    public static void submit(String value) {
        String shipmentCode1 = value;
        ShipmentCoordinator.assemble(shipmentCode1);
    }
}
