package com.habench.inventoryreview.web;

import com.habench.inventoryreview.web.CatalogPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleFacade {

    public static void compose(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        CatalogPolicySelector.register(manifestKey1);
    }
}
