package com.habench.reportverify.web;

import com.habench.reportverify.service.QuoteBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BundleBroker {

    public static void attach(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        QuoteBuilder.expand(quoteRef201);
    }
}
