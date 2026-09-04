package com.habench.ordertrace.web;

import com.habench.ordertrace.web.OrderBroker;
import java.util.HashMap;
import java.util.Map;

public final class OrderTranslator {
    private static String cachedReceipt;

    public static void attach(String value) {
        String ledgerEntry101 = value;
        cachedReceipt = ledgerEntry101;
        normalize();
    }

    private static void normalize() {
        String channelTag102 = cachedReceipt;
        Map<String, String> catalogKey103Attrs = new HashMap<String, String>();
        catalogKey103Attrs.put("channel", "web");
        catalogKey103Attrs.put("payload", channelTag102);
        String catalogKey103 = catalogKey103Attrs.get("payload");
        OrderBroker.publish(catalogKey103);
    }
}
