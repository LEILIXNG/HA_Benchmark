package com.habench.reportquote.service;

import com.habench.reportquote.service.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleCollector {

    public static void dispatch(String value) {
        String orderRef101 = value;
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        InvoiceRuleSelector.enrich(quoteRef102);
    }
}
