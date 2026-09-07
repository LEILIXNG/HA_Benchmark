package com.habench.inventorylookup.service;

import com.habench.inventorylookup.service.ShipmentBroker;

public final class BundleCoordinator {

    public static void normalize(String value) {
        String manifestKey101 = "ref:" + value + ";";
        String invoiceKey102 = manifestKey101;
        ShipmentBroker.merge(invoiceKey102);
    }
}
