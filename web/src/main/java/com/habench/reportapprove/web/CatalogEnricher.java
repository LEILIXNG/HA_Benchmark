package com.habench.reportapprove.web;

import com.habench.reportapprove.web.TariffStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {

    public static void translate(String value) {
        String channelTag201 = "ref:" + value + ";";
        Map<String, String> catalogKey202Attrs = new HashMap<String, String>();
        catalogKey202Attrs.put("channel", "web");
        catalogKey202Attrs.put("payload", channelTag201);
        String catalogKey202 = catalogKey202Attrs.get("payload");
        TariffStrategySelector.resolve(catalogKey202);
    }
}
