package com.habench.inventorytrace.service;

import com.habench.inventorytrace.service.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {

    public static void forward(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        String quoteRef102 = "ref:" + orderRef101 + ";";
        OrderRepository.enrich(quoteRef102);
    }
}
