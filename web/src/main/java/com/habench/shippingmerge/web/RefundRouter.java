package com.habench.shippingmerge.web;

import com.habench.shippingmerge.web.CatalogEnricher;
import java.util.HashMap;
import java.util.Map;

public final class RefundRouter {

    public static void enrich(String value) {
        Map<String, String> channelTag1Attrs = new HashMap<String, String>();
        channelTag1Attrs.put("channel", "web");
        channelTag1Attrs.put("payload", value);
        String channelTag1 = channelTag1Attrs.get("payload");
        CatalogEnricher.merge(channelTag1);
    }
}
