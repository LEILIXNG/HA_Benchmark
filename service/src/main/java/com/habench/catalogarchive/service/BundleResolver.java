package com.habench.catalogarchive.service;

import com.habench.catalogarchive.dao.VoucherRouter;

public final class BundleResolver {
    private String pendingShipment;

    public static void translate(String value) {
        BundleResolver self = new BundleResolver();
        self.stage(value);
    }

    private void stage(String value) {
        String ledgerEntry201 = value;
        this.pendingShipment = ledgerEntry201;
        register();
    }

    private void register() {
        String channelTag202 = this.pendingShipment;
        String catalogKey203 = "ref:" + channelTag202 + ";";
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        VoucherRouter.collect(receiptKey204);
    }
}
