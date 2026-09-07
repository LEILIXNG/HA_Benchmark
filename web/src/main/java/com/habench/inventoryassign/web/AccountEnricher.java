package com.habench.inventoryassign.web;

import com.habench.inventoryassign.web.ManifestExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountEnricher {

    public static void collect(String value) {
        String refundCode201 = value;
        Map<String, String> shipmentCode202Attrs = new HashMap<String, String>();
        shipmentCode202Attrs.put("channel", "web");
        shipmentCode202Attrs.put("payload", refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get("payload");
        ManifestExecutor.reconcile(shipmentCode202);
    }
}
