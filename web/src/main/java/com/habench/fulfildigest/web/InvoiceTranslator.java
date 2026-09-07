package com.habench.fulfildigest.web;

import com.habench.fulfildigest.service.RefundCollector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceTranslator {

    public static void refine(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        RefundCollector.compose(quoteRef201);
    }
}
