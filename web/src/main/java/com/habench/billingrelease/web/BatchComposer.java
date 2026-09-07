package com.habench.billingrelease.web;

import com.habench.billingrelease.service.SessionResolver;
import java.util.HashMap;
import java.util.Map;

public final class BatchComposer {

    public static void enrich(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        String quoteRef2 = orderRef1;
        SessionResolver.expand(quoteRef2);
    }
}
