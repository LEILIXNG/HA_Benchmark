package com.habench.accountreview.web;

import com.habench.accountreview.service.SessionRegistry;
import java.util.HashMap;
import java.util.Map;

public final class SessionFacade {
    private static String cachedCatalog;

    public static void expand(String value) {
        String ledgerEntry101 = value;
        cachedCatalog = ledgerEntry101;
        dispatch();
    }

    private static void dispatch() {
        String channelTag102 = cachedCatalog;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("payload", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("payload");
        SessionRegistry.expand(catalogKey103);
    }
}
