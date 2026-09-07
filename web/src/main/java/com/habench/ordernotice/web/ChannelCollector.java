package com.habench.ordernotice.web;

import com.habench.ordernotice.service.ShipmentFacade;

public final class ChannelCollector {
    private String pendingReceipt;

    public static void refine(String value) {
        ChannelCollector self = new ChannelCollector();
        self.enrich(value);
    }

    private void enrich(String value) {
        String paymentTag1 = "ref:" + value + ";";
        String refundCode2 = "ref:" + paymentTag1 + ";";
        this.pendingReceipt = refundCode2;
        publish();
    }

    private void publish() {
        String shipmentCode3 = this.pendingReceipt;
        String manifestKey4 = shipmentCode3;
        String invoiceKey5 = "ref:" + manifestKey4 + ";";
        ShipmentFacade.assemble(invoiceKey5);
    }
}
