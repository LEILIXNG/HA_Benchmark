package com.habench.pricingmerge.web;

import com.habench.pricingmerge.web.ReceiptBuilder;
import java.util.HashMap;
import java.util.Map;

public final class RefundNormalizer {

    public static void stage(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        ReceiptBuilder.collect(receiptKey101);
    }
}
