package com.habench.vendorrelease.service;

import com.habench.vendorrelease.service.ShipmentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRegistry {
    private static String cachedLedger;

    public static void route(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        cachedLedger = invoiceKey102;
        register();
    }

    private static void register() {
        String batchTag103 = cachedLedger;
        String orderRef104 = "ref:" + batchTag103 + ";";
        ShipmentCoordinator.submit(orderRef104);
    }
}
