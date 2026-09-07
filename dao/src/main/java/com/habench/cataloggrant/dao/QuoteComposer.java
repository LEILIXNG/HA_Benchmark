package com.habench.cataloggrant.dao;

import com.habench.cataloggrant.dao.ManifestExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {

    public static void route(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("payload", value);
        String manifestKey401 = manifestKey401Attrs.get("payload");
        String invoiceKey402 = manifestKey401;
        ManifestExecutor.collect(invoiceKey402);
    }
}
