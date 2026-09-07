package com.habench.accountreopen.web;

import com.habench.accountreopen.service.ReceiptEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRegistry {

    public static void merge(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        ReceiptEnricher.enrich(batchTag2);
    }
}
