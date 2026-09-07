package com.habench.billingrollup.service;

import com.habench.billingrollup.dao.QuoteTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundBuilder {

    public static void refine(String value) {
        String manifestKey201 = value;
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        QuoteTranslator.reconcile(invoiceKey202);
    }
}
