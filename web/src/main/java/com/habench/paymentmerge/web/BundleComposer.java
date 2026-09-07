package com.habench.paymentmerge.web;

import com.habench.paymentmerge.service.QuoteCollector;
import java.util.HashMap;
import java.util.Map;

public final class BundleComposer {

    public static void publish(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        QuoteCollector.route(quoteRef2);
    }
}
