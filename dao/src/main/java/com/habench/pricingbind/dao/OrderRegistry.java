package com.habench.pricingbind.dao;

import com.habench.pricingbind.dao.ReceiptRegistry;
import java.util.HashMap;
import java.util.Map;

public final class OrderRegistry {

    public static void attach(String value) {
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("payload", value);
        String catalogKey201 = catalogKey201Attrs.get("payload");
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        ReceiptRegistry.normalize(receiptKey202);
    }
}
