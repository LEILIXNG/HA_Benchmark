package com.habench.inventoryintake.web;

import com.habench.inventoryintake.service.BundleCoordinator;

public final class ShipmentResolver {

    public static void stage(String value) {
        String refundCode1 = value;
        BundleCoordinator.resolve(refundCode1);
    }
}
