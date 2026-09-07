package com.habench.accountsplit.dao;

import com.habench.accountsplit.dao.ShipmentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class OrderRegistry {

    public static void collect(String value) {
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("payload", value);
        String receiptKey201 = receiptKey201Attrs.get("payload");
        ShipmentExecutor.route(receiptKey201);
    }
}
