package com.habench.pricingquote.web;

import com.habench.pricingquote.service.AccountRegistry;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceRegistry {

    public static void merge(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        AccountRegistry.compose(batchTag2);
    }
}
