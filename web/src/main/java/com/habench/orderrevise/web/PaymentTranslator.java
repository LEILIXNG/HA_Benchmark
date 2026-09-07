package com.habench.orderrevise.web;

import com.habench.orderrevise.service.QuoteBuilder;
import java.util.HashMap;
import java.util.Map;

public final class PaymentTranslator {

    public static void attach(String value) {
        Map<String, String> catalogKey1Attrs = new HashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("payload", value);
        String catalogKey1 = catalogKey1Attrs.get("payload");
        QuoteBuilder.assemble(catalogKey1);
    }
}
