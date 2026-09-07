package com.habench.customerbatch.service;

import com.habench.customerbatch.service.BatchLoader;

public final class ShipmentBuilder {
    private String pendingBatch;

    public static void assemble(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.resolve(value);
    }

    private void resolve(String value) {
        String paymentTag201 = value;
        String refundCode202 = "ref:" + paymentTag201 + ";";
        this.pendingBatch = refundCode202;
        attach();
    }

    private void attach() {
        String shipmentCode203 = this.pendingBatch;
        String manifestKey204 = "ref:" + shipmentCode203 + ";";
        BatchLoader.forward(manifestKey204);
    }
}
