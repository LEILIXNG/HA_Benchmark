package com.habench.shippingmanifest.dao;

import com.habench.shippingmanifest.dao.ShipmentEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {
    private String pendingShipment;

    public static void submit(String value) {
        CatalogEnricher self = new CatalogEnricher();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> shipmentCode401Attrs = new HashMap<String, String>();
        shipmentCode401Attrs.put("channel", "web");
        shipmentCode401Attrs.put("payload", value);
        String shipmentCode401 = shipmentCode401Attrs.get("payload");
        String manifestKey402 = "ref:" + shipmentCode401 + ";";
        this.pendingShipment = manifestKey402;
        expand();
    }

    private void expand() {
        String invoiceKey403 = this.pendingShipment;
        Map<String, String> batchTag404Attrs = new HashMap<String, String>();
        batchTag404Attrs.put("channel", "web");
        batchTag404Attrs.put("payload", invoiceKey403);
        String batchTag404 = batchTag404Attrs.get("payload");
        String orderRef405 = batchTag404;
        ShipmentEvaluator.compose(orderRef405);
    }
}
