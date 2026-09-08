package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.service.ReceiptBuilder;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptResolver {

    public static void expand(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        ReceiptBuilder.merge(receiptKey2);
    }
}
