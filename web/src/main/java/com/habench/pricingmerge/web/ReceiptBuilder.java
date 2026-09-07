package com.habench.pricingmerge.web;

import com.habench.pricingmerge.service.InvoiceTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBuilder {

    public static void collect(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        InvoiceTranslator.collect(quoteRef201);
    }
}
