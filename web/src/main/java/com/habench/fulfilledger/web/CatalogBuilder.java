package com.habench.fulfilledger.web;

import com.habench.fulfilledger.web.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogBuilder {

    public static void attach(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        TariffPolicySelector.register(catalogKey1);
    }
}
