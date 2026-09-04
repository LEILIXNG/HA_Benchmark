package com.habench.catalogissue.service;

import com.habench.catalogissue.service.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteCollector {

    public static void enrich(String value) {
        Map<String, String> paymentTag301Attrs = new HashMap<String, String>();
        paymentTag301Attrs.put("channel", "web");
        paymentTag301Attrs.put("payload", value);
        String paymentTag301 = paymentTag301Attrs.get("payload");
        InvoiceRuleSelector.merge(paymentTag301);
    }
}
