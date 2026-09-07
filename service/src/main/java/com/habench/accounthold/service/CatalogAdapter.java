package com.habench.accounthold.service;

import com.habench.accounthold.service.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogAdapter {
    private String pendingSession;

    public static void submit(String value) {
        CatalogAdapter self = new CatalogAdapter();
        self.enrich(value);
    }

    private void enrich(String value) {
        String refundCode101 = "ref:" + value + ";";
        this.pendingSession = refundCode101;
        resolve();
    }

    private void resolve() {
        String shipmentCode102 = this.pendingSession;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        ShipmentStrategySelector.attach(invoiceKey104);
    }
}
