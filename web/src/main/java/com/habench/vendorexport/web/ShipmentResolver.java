package com.habench.vendorexport.web;

import com.habench.vendorexport.service.BundleCoordinator;

public final class ShipmentResolver {

    public static void stage(String value) {
        String refundCode1 = value;
        BundleCoordinator.resolve(refundCode1);
    }
}
