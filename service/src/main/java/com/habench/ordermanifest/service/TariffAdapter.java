package com.habench.ordermanifest.service;

import com.habench.ordermanifest.dao.OrderService;
import java.util.HashMap;
import java.util.Map;

public final class TariffAdapter {

    public static void publish(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        OrderService.resolve(quoteRef201);
    }
}
