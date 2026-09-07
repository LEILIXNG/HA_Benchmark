package com.habench.reportreopen.service;

import com.habench.reportreopen.dao.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private static String cachedBatch;

    public static void submit(String value) {
        String ledgerEntry201 = value;
        cachedBatch = ledgerEntry201;
        collect();
    }

    private static void collect() {
        String channelTag202 = cachedBatch;
        Map<String, String> catalogKey203Attrs = new HashMap<String, String>();
        catalogKey203Attrs.put("channel", "web");
        catalogKey203Attrs.put("payload", channelTag202);
        String catalogKey203 = catalogKey203Attrs.get("payload");
        PaymentTranslator.enrich(catalogKey203);
    }
}
