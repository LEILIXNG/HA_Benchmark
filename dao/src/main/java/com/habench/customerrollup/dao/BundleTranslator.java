package com.habench.customerrollup.dao;

import com.habench.customerrollup.dao.QuoteScreen;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {

    public static void enrich(String value) {
        Map<String, String> catalogKey601Attrs = new HashMap<String, String>();
        catalogKey601Attrs.put("channel", "web");
        catalogKey601Attrs.put("payload", value);
        String catalogKey601 = catalogKey601Attrs.get("payload");
        QuoteScreen.enrich(catalogKey601);
    }
}
