package com.habench.inventorybatch.service;

import com.habench.inventorybatch.dao.ReceiptEnricher;
import java.util.HashMap;
import java.util.Map;

public final class BundleCollector {

    public static void register(String value) {
        String refundCode201 = value;
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        ReceiptEnricher.forward(shipmentCode202);
    }
}
