package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.service.ManifestRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {

    public static void stage(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        ManifestRegistry.reconcile(invoiceKey102);
    }
}
