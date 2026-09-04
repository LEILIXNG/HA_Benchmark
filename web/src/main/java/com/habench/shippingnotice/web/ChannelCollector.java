package com.habench.shippingnotice.web;

import com.habench.shippingnotice.service.TariffCollector;

public final class ChannelCollector {
    private String pendingShipment;

    public static void merge(String value) {
        ChannelCollector self = new ChannelCollector();
        self.attach(value);
    }

    private void attach(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        this.pendingShipment = invoiceKey1;
        reconcile();
    }

    private void reconcile() {
        String batchTag2 = this.pendingShipment;
        String orderRef3 = batchTag2;
        String quoteRef4 = orderRef3;
        TariffCollector.forward(quoteRef4);
    }
}
