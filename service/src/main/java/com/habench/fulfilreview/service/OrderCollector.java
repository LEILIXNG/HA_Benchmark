package com.habench.fulfilreview.service;

import com.habench.fulfilreview.service.QuotePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class OrderCollector {

    public static void translate(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        QuotePolicySelector.route(paymentTag201);
    }
}
