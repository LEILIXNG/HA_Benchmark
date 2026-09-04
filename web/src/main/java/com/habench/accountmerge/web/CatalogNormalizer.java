package com.habench.accountmerge.web;

import com.habench.accountmerge.service.QuoteEnricher;
import java.util.HashMap;
import java.util.Map;

public final class CatalogNormalizer {

    public static void refine(String value) {
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("payload", value);
        String manifestKey1 = manifestKey1Attrs.get("payload");
        QuoteEnricher.route(manifestKey1);
    }
}
