package com.habench.ordersettle.web;

import com.habench.ordersettle.service.OrderResolver;
import java.util.HashMap;
import java.util.Map;

public final class RefundFacade {
    private static String cachedShipment;

    public static void submit(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        cachedShipment = ledgerEntry1;
        forward();
    }

    private static void forward() {
        String channelTag2 = cachedShipment;
        String catalogKey3 = channelTag2;
        String receiptKey4 = catalogKey3;
        OrderResolver.attach(receiptKey4);
    }
}
