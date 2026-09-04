package com.habench.shippingnotice.dao;

import com.habench.shippingnotice.dao.ShipmentLoader;

public final class OrderCoordinator {
    private String pendingShipment;

    public static void refine(String value) {
        OrderCoordinator self = new OrderCoordinator();
        self.resolve(value);
    }

    private void resolve(String value) {
        String voucherRef401 = "ref:" + value + ";";
        String paymentTag402 = "ref:" + voucherRef401 + ";";
        this.pendingShipment = paymentTag402;
        enrich();
    }

    private void enrich() {
        String refundCode403 = this.pendingShipment;
        String shipmentCode404 = refundCode403;
        String manifestKey405 = shipmentCode404;
        ShipmentLoader.collect(manifestKey405);
    }
}
