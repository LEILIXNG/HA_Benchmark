package com.habench.pricingarchive.web;

import com.habench.pricingarchive.service.AccountTranslator;
import java.util.HashMap;
import java.util.Map;

public final class QuoteRouter {

    public static void publish(String value) {
        String catalogKey1 = value;
        Map<String, String> receiptKey2Attrs = new HashMap<String, String>();
        receiptKey2Attrs.put("channel", "web");
        receiptKey2Attrs.put("payload", catalogKey1);
        String receiptKey2 = receiptKey2Attrs.get("payload");
        AccountTranslator.expand(receiptKey2);
    }
}
