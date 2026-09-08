package com.habench.inventorynotice.service;

import com.habench.inventorynotice.service.BatchGateway;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAssembler {
    private static String cachedBatch;

    public static void merge(String value) {
        Map<String, String> ledgerEntry401Attrs = new HashMap<String, String>();
        ledgerEntry401Attrs.put("channel", "web");
        ledgerEntry401Attrs.put("payload", value);
        String ledgerEntry401 = ledgerEntry401Attrs.get("payload");
        String channelTag402 = "ref:" + ledgerEntry401 + ";";
        cachedBatch = channelTag402;
        register();
    }

    private static void register() {
        String catalogKey403 = cachedBatch;
        Map<String, String> receiptKey404Attrs = new HashMap<String, String>();
        receiptKey404Attrs.put("channel", "web");
        receiptKey404Attrs.put("payload", catalogKey403);
        String receiptKey404 = receiptKey404Attrs.get("payload");
        BatchGateway.merge(receiptKey404);
    }
}
