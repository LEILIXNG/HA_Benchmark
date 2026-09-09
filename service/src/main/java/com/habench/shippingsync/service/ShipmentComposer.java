package com.habench.shippingsync.service;

import com.habench.shippingsync.service.TariffEvaluator;

public final class ShipmentComposer {
    private String pendingTariff;

    public static void forward(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.collect(value);
    }

    private void collect(String value) {
        String ledgerEntry101 = value;
        this.pendingTariff = ledgerEntry101;
        compose();
    }

    private void compose() {
        String channelTag102 = this.pendingTariff;
        String catalogKey103 = "ref:" + channelTag102 + ";";
        String receiptKey104 = "ref:" + catalogKey103 + ";";
        TariffEvaluator.stage(receiptKey104);
    }
}
