package com.habench.shippingposting.service;

import com.habench.shippingposting.service.InvoicePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentTranslator {

    public static void enrich(String value) {
        String shipmentCode101 = "ref:" + value + ";";
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        InvoicePolicySelector.collect(manifestKey102);
    }
}
