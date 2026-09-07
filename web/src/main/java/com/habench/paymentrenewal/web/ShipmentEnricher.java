package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.QuotePlanSelector;

public final class ShipmentEnricher {
    private String pendingManifest;

    public static void forward(String value) {
        ShipmentEnricher self = new ShipmentEnricher();
        self.register(value);
    }

    private void register(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        this.pendingManifest = receiptKey2;
        prepare();
    }

    private void prepare() {
        String accountRef3 = this.pendingManifest;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        QuotePlanSelector.collect(voucherRef4);
    }
}
