package com.habench.reportsettle.web;

import com.habench.reportsettle.service.QuoteCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class RefundEnricher {

    public static void refine(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        Map<String, String> quoteRef202Attrs = new HashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("payload", orderRef201);
        String quoteRef202 = quoteRef202Attrs.get("payload");
        QuoteCoordinator.attach(quoteRef202);
    }
}
