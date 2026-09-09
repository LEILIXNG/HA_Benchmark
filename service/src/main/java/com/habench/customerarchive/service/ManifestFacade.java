package com.habench.customerarchive.service;

import com.habench.customerarchive.service.PaymentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestFacade {
    private static String cachedSession;

    public static void enrich(String value) {
        String refundCode101 = value;
        cachedSession = refundCode101;
        expand();
    }

    private static void expand() {
        String shipmentCode102 = cachedSession;
        Map<String, String> manifestKey103Attrs = new HashMap<String, String>();
        manifestKey103Attrs.put("channel", "web");
        manifestKey103Attrs.put("payload", shipmentCode102);
        String manifestKey103 = manifestKey103Attrs.get("payload");
        cachedSession = manifestKey103;
        route();
    }

    private static void route() {
        String invoiceKey104 = cachedSession;
        Map<String, String> batchTag105Attrs = new HashMap<String, String>();
        batchTag105Attrs.put("channel", "web");
        batchTag105Attrs.put("payload", invoiceKey104);
        String batchTag105 = batchTag105Attrs.get("payload");
        Map<String, String> orderRef106Attrs = new HashMap<String, String>();
        orderRef106Attrs.put("channel", "web");
        orderRef106Attrs.put("payload", batchTag105);
        String orderRef106 = orderRef106Attrs.get("payload");
        PaymentStrategySelector.route(orderRef106);
    }
}
