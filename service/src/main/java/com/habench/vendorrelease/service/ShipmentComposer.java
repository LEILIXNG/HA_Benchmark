package com.habench.vendorrelease.service;

import com.habench.vendorrelease.dao.CatalogService;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {
    private String pendingRefund;

    public static void enrich(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.stage(value);
    }

    private void stage(String value) {
        String refundCode401 = "ref:" + value + ";";
        this.pendingRefund = refundCode401;
        forward();
    }

    private void forward() {
        String shipmentCode402 = this.pendingRefund;
        Map<String, String> manifestKey403Attrs = new HashMap<String, String>();
        manifestKey403Attrs.put("channel", "web");
        manifestKey403Attrs.put("payload", shipmentCode402);
        String manifestKey403 = manifestKey403Attrs.get("payload");
        String invoiceKey404 = manifestKey403;
        CatalogService.translate(invoiceKey404);
    }
}
