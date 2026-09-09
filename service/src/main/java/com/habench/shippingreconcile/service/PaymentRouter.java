package com.habench.shippingreconcile.service;

import com.habench.shippingreconcile.dao.PaymentResolver;
import java.util.HashMap;
import java.util.Map;

public final class PaymentRouter {
    private static String cachedPayment;

    public static void expand(String value) {
        String tariffRef101 = value;
        cachedPayment = tariffRef101;
        enrich();
    }

    private static void enrich() {
        String ledgerEntry102 = cachedPayment;
        Map<String, String> channelTag103Attrs = new HashMap<String, String>();
        channelTag103Attrs.put("channel", "web");
        channelTag103Attrs.put("payload", ledgerEntry102);
        String channelTag103 = channelTag103Attrs.get("payload");
        Map<String, String> catalogKey104Attrs = new HashMap<String, String>();
        catalogKey104Attrs.put("channel", "web");
        catalogKey104Attrs.put("payload", channelTag103);
        String catalogKey104 = catalogKey104Attrs.get("payload");
        PaymentResolver.translate(catalogKey104);
    }
}
