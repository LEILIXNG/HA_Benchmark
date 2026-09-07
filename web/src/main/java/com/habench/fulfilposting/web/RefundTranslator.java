package com.habench.fulfilposting.web;

import com.habench.fulfilposting.service.RefundAdapter;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {

    public static void reconcile(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        RefundAdapter.register(batchTag2);
    }
}
