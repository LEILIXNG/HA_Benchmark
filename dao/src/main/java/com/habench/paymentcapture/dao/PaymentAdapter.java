package com.habench.paymentcapture.dao;

import com.habench.paymentcapture.dao.ShipmentLoader;

public final class PaymentAdapter {
    private String pendingShipment;

    public static void expand(String value) {
        PaymentAdapter self = new PaymentAdapter();
        self.stage(value);
    }

    private void stage(String value) {
        String tariffRef201 = "ref:" + value + ";";
        this.pendingShipment = tariffRef201;
        attach();
    }

    private void attach() {
        String ledgerEntry202 = this.pendingShipment;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        ShipmentLoader.normalize(channelTag203);
    }
}
