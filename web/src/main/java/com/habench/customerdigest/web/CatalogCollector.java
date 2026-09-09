package com.habench.customerdigest.web;

import com.habench.customerdigest.web.CatalogPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCollector {
    private static String cachedPayment;

    public static void normalize(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        cachedPayment = ledgerEntry1;
        assemble();
    }

    private static void assemble() {
        String channelTag2 = cachedPayment;
        String catalogKey3 = channelTag2;
        CatalogPolicySelector.stage(catalogKey3);
    }
}
