package com.habench.inventorylookup.service;

import com.habench.inventorylookup.service.ReceiptCollector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentBroker {

    public static void normalize(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        ReceiptCollector.collect(invoiceKey102);
    }
}
