package com.habench.pricingrollup.web;

import com.habench.pricingrollup.service.BundleCoordinator;

public final class ShipmentResolver {

    public static void stage(String value) {
        String catalogKey1 = value;
        BundleCoordinator.resolve(catalogKey1);
    }
}
