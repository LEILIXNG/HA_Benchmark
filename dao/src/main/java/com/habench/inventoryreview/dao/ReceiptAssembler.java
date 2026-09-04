package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.BundlePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAssembler {

    public static void enrich(String value) {
        Map<String, String> manifestKey201Attrs = new HashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("payload", value);
        String manifestKey201 = manifestKey201Attrs.get("payload");
        BundlePlanSelector.assemble(manifestKey201);
    }
}
