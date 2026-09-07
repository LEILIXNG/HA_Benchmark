package com.habench.vendorissue.service;

import com.habench.vendorissue.dao.ShipmentBuilder;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {

    public static void enrich(String value) {
        Map<String, String> orderRef501Attrs = new HashMap<String, String>();
        orderRef501Attrs.put("channel", "web");
        orderRef501Attrs.put("payload", value);
        String orderRef501 = orderRef501Attrs.get("payload");
        String quoteRef502 = orderRef501;
        ShipmentBuilder.reconcile(quoteRef502);
    }
}
