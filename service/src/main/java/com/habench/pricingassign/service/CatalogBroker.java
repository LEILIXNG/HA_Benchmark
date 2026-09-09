package com.habench.pricingassign.service;

import com.habench.pricingassign.service.ShipmentGateway;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBroker {
    private String pendingShipment;

    public static void reconcile(String value) {
        CatalogBroker self = new CatalogBroker();
        self.refine(value);
    }

    private void refine(String value) {
        String refundCode201 = value;
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        this.pendingShipment = shipmentCode202;
        enrich();
    }

    private void enrich() {
        String manifestKey203 = this.pendingShipment;
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("payload", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("payload");
        this.pendingShipment = invoiceKey204;
        collect();
    }

    private void collect() {
        String batchTag205 = this.pendingShipment;
        Map<String, String> orderRef206Attrs = new HashMap<String, String>();
        orderRef206Attrs.put("channel", "web");
        orderRef206Attrs.put("payload", batchTag205);
        String orderRef206 = orderRef206Attrs.get("payload");
        String quoteRef207 = "ref:" + orderRef206 + ";";
        ShipmentGateway.expand(quoteRef207);
    }
}
