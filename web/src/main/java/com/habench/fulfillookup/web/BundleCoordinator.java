package com.habench.fulfillookup.web;

import com.habench.fulfillookup.service.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BundleCoordinator {

    public static void resolve(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        String batchTag2 = invoiceKey1;
        PaymentTranslator.refine(batchTag2);
    }
}
