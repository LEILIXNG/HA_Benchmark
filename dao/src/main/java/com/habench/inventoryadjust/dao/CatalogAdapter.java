package com.habench.inventoryadjust.dao;

import com.habench.inventoryadjust.dao.ShipmentGateway;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAdapter {
    private String pendingShipment;

    public static void publish(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.merge(value);
    }

    private void merge(String value) {
        String refundCode401 = "ref:" + value + ";";
        String shipmentCode402 = "ref:" + refundCode401 + ";";
        this.pendingShipment = shipmentCode402;
        collect();
    }

    private void collect() {
        String manifestKey403 = this.pendingShipment;
        Map<String, String> invoiceKey404Attrs = new HashMap<String, String>();
        invoiceKey404Attrs.put("channel", "web");
        invoiceKey404Attrs.put("payload", manifestKey403);
        String invoiceKey404 = invoiceKey404Attrs.get("payload");
        ShipmentGateway.publish(invoiceKey404);
    }
}
