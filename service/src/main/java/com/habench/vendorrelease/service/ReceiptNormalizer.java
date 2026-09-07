package com.habench.vendorrelease.service;

import com.habench.vendorrelease.service.ShipmentComposer;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptNormalizer {
    private String pendingRefund;

    public static void translate(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        String quoteRef302 = "ref:" + orderRef301 + ";";
        this.pendingRefund = quoteRef302;
        forward();
    }

    private void forward() {
        String tariffRef303 = this.pendingRefund;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("payload", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("payload");
        ShipmentComposer.enrich(ledgerEntry304);
    }
}
