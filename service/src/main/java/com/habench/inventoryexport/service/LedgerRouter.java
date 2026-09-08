package com.habench.inventoryexport.service;

import com.habench.inventoryexport.service.RefundGateway;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRouter {

    public static void route(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        String manifestKey102 = "ref:" + shipmentCode101 + ";";
        RefundGateway.register(manifestKey102);
    }
}
