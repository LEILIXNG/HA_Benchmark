package com.habench.paymentexport.service;

import com.habench.paymentexport.service.OrderFetcher;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private static String cachedOrder;

    public static void forward(String value) {
        String refundCode201 = value;
        String shipmentCode202 = refundCode201;
        cachedOrder = shipmentCode202;
        register();
    }

    private static void register() {
        String manifestKey203 = cachedOrder;
        Map<String, String> invoiceKey204Attrs = new HashMap<String, String>();
        invoiceKey204Attrs.put("channel", "web");
        invoiceKey204Attrs.put("payload", manifestKey203);
        String invoiceKey204 = invoiceKey204Attrs.get("payload");
        OrderFetcher.forward(invoiceKey204);
    }
}
