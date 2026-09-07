package com.habench.orderrevise.service;

import com.habench.orderrevise.dao.ReceiptResolver;
import java.util.HashMap;
import java.util.Map;

public final class SessionNormalizer {

    public static void publish(String value) {
        Map<String, String> catalogKey301Attrs = new HashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("payload", value);
        String catalogKey301 = catalogKey301Attrs.get("payload");
        String receiptKey302 = catalogKey301;
        ReceiptResolver.forward(receiptKey302);
    }
}
