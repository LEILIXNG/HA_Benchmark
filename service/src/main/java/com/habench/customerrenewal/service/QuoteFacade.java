package com.habench.customerrenewal.service;

import com.habench.customerrenewal.service.CatalogPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteFacade {

    public static void resolve(String value) {
        String shipmentCode101 = value;
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("payload", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("payload");
        CatalogPolicySelector.collect(manifestKey102);
    }
}
