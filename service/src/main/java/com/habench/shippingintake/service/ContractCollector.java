package com.habench.shippingintake.service;

import com.habench.shippingintake.dao.SessionCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ContractCollector {

    public static void route(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("payload", value);
        String catalogKey301 = catalogKey301Attrs.get("payload");
        Map<String, String> receiptKey302Attrs = new HashMap<String, String>();
        receiptKey302Attrs.put("channel", "web");
        receiptKey302Attrs.put("payload", catalogKey301);
        String receiptKey302 = receiptKey302Attrs.get("payload");
        SessionCoordinator.route(receiptKey302);
    }
}
