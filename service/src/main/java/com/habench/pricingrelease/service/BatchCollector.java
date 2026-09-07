package com.habench.pricingrelease.service;

import com.habench.pricingrelease.service.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchCollector {

    public static void publish(String value) {
        String orderRef101 = "ref:" + value + ";";
        Map<String, String> quoteRef102Attrs = new HashMap<String, String>();
        quoteRef102Attrs.put("channel", "web");
        quoteRef102Attrs.put("payload", orderRef101);
        String quoteRef102 = quoteRef102Attrs.get("payload");
        QuotePolicySelector.prepare(quoteRef102);
    }
}
