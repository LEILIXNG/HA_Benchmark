package com.habench.catalogrenewal.service;

import com.habench.catalogrenewal.dao.ShipmentRouter;

public final class BundleCoordinator {

    public static void dispatch(String value) {
        String refundCode401 = value;
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        ShipmentRouter.attach(shipmentCode402);
    }
}
