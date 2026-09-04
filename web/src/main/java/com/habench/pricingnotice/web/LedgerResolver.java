package com.habench.pricingnotice.web;

import com.habench.pricingnotice.web.OrderTranslator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerResolver {

    public static void normalize(String value) {
        Map<String, String> quoteRef201Attrs = new HashMap<String, String>();
        quoteRef201Attrs.put("channel", "web");
        quoteRef201Attrs.put("payload", value);
        String quoteRef201 = quoteRef201Attrs.get("payload");
        String tariffRef202 = quoteRef201;
        OrderTranslator.prepare(tariffRef202);
    }
}
