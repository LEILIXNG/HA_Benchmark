package com.habench.vendordigest.web;

import com.habench.vendordigest.service.ShipmentBroker;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBroker {
    private static String cachedTariff;

    public static void attach(String value) {
        String manifestKey101 = value;
        cachedTariff = manifestKey101;
        collect();
    }

    private static void collect() {
        String invoiceKey102 = cachedTariff;
        String batchTag103 = invoiceKey102;
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        ShipmentBroker.enrich(orderRef104);
    }
}
