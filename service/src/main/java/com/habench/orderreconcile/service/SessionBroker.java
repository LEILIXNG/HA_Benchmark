package com.habench.orderreconcile.service;

import com.habench.orderreconcile.service.ShipmentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class SessionBroker {

    public static void collect(String value) {
        String catalogKey201 = value;
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        ShipmentStrategySelector.attach(receiptKey202);
    }
}
