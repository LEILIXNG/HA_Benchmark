package com.habench.catalognotice.dao;

import com.habench.catalognotice.dao.AccountStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {
    private static String cachedOrder;

    public static void merge(String value) {
        String batchTag201 = "ref:" + value + ";";
        cachedOrder = batchTag201;
        enrich();
    }

    private static void enrich() {
        String orderRef202 = cachedOrder;
        Map<String, String> quoteRef203Attrs = new HashMap<String, String>();
        quoteRef203Attrs.put("channel", "web");
        quoteRef203Attrs.put("payload", orderRef202);
        String quoteRef203 = quoteRef203Attrs.get("payload");
        AccountStrategySelector.assemble(quoteRef203);
    }
}
