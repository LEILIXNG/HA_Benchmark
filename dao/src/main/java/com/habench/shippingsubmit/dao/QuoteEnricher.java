package com.habench.shippingsubmit.dao;

import com.habench.shippingsubmit.dao.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {

    public static void publish(String value) {
        Map<String, String> quoteRef601Attrs = new HashMap<String, String>();
        quoteRef601Attrs.put("channel", "web");
        quoteRef601Attrs.put("payload", value);
        String quoteRef601 = quoteRef601Attrs.get("payload");
        BundleExecutor.enrich(quoteRef601);
    }
}
