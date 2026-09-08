package com.habench.inventoryposting.web;

import com.habench.inventoryposting.web.ManifestStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {

    public static void translate(String value) {
        String manifestKey1 = value;
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        ManifestStrategySelector.enrich(invoiceKey2);
    }
}
