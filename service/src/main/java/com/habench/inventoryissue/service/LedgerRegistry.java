package com.habench.inventoryissue.service;

import com.habench.inventoryissue.dao.ManifestCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRegistry {

    public static void route(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        String batchTag302 = invoiceKey301;
        ManifestCoordinator.collect(batchTag302);
    }
}
