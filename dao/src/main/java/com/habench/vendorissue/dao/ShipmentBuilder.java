package com.habench.vendorissue.dao;

import com.habench.vendorissue.dao.TariffEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBuilder {
    private String pendingTariff;

    public static void reconcile(String value) {
        ShipmentBuilder self = new ShipmentBuilder();
        self.translate(value);
    }

    private void translate(String value) {
        String refundCode601 = "ref:" + value + ";";
        String shipmentCode602 = refundCode601;
        this.pendingTariff = shipmentCode602;
        expand();
    }

    private void expand() {
        String manifestKey603 = this.pendingTariff;
        Map<String, String> invoiceKey604Attrs = new HashMap<String, String>();
        invoiceKey604Attrs.put("channel", "web");
        invoiceKey604Attrs.put("payload", manifestKey603);
        String invoiceKey604 = invoiceKey604Attrs.get("payload");
        String batchTag605 = "ref:" + invoiceKey604 + ";";
        TariffEvaluator.enrich(batchTag605);
    }
}
