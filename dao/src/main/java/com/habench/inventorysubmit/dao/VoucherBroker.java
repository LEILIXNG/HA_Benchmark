package com.habench.inventorysubmit.dao;

import com.habench.inventorysubmit.dao.ShipmentExecutor;

public final class VoucherBroker {
    private String pendingShipment;

    public static void collect(String value) {
        VoucherBroker self = new VoucherBroker();
        self.expand(value);
    }

    private void expand(String value) {
        String accountRef301 = "ref:" + value + ";";
        this.pendingShipment = accountRef301;
        dispatch();
    }

    private void dispatch() {
        String voucherRef302 = this.pendingShipment;
        String paymentTag303 = voucherRef302;
        this.pendingShipment = paymentTag303;
        merge();
    }

    private void merge() {
        String refundCode304 = this.pendingShipment;
        String shipmentCode305 = refundCode304;
        String manifestKey306 = shipmentCode305;
        ShipmentExecutor.merge(manifestKey306);
    }
}
