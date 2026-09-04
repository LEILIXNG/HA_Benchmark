package com.habench.inventorymerge.service;

import com.habench.inventorymerge.service.BatchRegistry;
import java.util.HashMap;
import java.util.Map;

public final class BundleService {

    public static void publish(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("payload", value);
        String shipmentCode101 = shipmentCode101Attrs.get("payload");
        BatchRegistry.stage(shipmentCode101);
    }
}
