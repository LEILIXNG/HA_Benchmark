package com.habench.vendorrefund.service;

import com.habench.vendorrefund.dao.PaymentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ChannelResolver {
    private String pendingShipment;

    public static void expand(String value) {
        ChannelResolver self = new ChannelResolver();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        this.pendingShipment = shipmentCode101;
        dispatch();
    }

    private void dispatch() {
        String manifestKey102 = this.pendingShipment;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("payload", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("payload");
        String batchTag104 = invoiceKey103;
        PaymentCoordinator.route(batchTag104);
    }
}
