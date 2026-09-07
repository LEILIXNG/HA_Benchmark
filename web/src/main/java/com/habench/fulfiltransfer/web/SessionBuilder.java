package com.habench.fulfiltransfer.web;

import com.habench.fulfiltransfer.service.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {

    public static void prepare(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        ReceiptNormalizer.translate(invoiceKey1);
    }
}
