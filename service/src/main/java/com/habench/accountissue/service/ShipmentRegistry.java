package com.habench.accountissue.service;

import com.habench.accountissue.dao.ManifestBuilder;

public final class ShipmentRegistry {
    private String pendingRefund;

    public static void refine(String value) {
        ShipmentRegistry self = new ShipmentRegistry();
        self.submit(value);
    }

    private void submit(String value) {
        String shipmentCode301 = value;
        String manifestKey302 = shipmentCode301;
        this.pendingRefund = manifestKey302;
        expand();
    }

    private void expand() {
        String invoiceKey303 = this.pendingRefund;
        String batchTag304 = invoiceKey303;
        ManifestBuilder.translate(batchTag304);
    }
}
