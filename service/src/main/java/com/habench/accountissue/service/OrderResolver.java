package com.habench.accountissue.service;

import com.habench.accountissue.service.ShipmentRegistry;
import java.util.HashMap;
import java.util.Map;

public final class OrderResolver {

    public static void reconcile(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        ShipmentRegistry.refine(quoteRef201);
    }
}
