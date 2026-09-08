package com.habench.customerrollup.dao;

import com.habench.customerrollup.dao.ShipmentStrategySelector;

public final class BatchTranslator {
    private String pendingAccount;

    public static void prepare(String value) {
        BatchTranslator self = new BatchTranslator();
        self.refine(value);
    }

    private void refine(String value) {
        String refundCode501 = value;
        this.pendingAccount = refundCode501;
        publish();
    }

    private void publish() {
        String shipmentCode502 = this.pendingAccount;
        String manifestKey503 = shipmentCode502;
        ShipmentStrategySelector.collect(manifestKey503);
    }
}
