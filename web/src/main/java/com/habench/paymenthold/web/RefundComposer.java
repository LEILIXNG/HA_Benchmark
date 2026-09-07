package com.habench.paymenthold.web;

import com.habench.paymenthold.web.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class RefundComposer {

    public static void translate(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        CatalogRegistry.stage(receiptKey2);
    }
}
