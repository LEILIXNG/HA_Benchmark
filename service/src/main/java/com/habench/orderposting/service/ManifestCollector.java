package com.habench.orderposting.service;

import com.habench.orderposting.service.OrderEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCollector {

    public static void attach(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        Map<String, String> orderRef202Attrs = new HashMap<String, String>();
        orderRef202Attrs.put("channel", "web");
        orderRef202Attrs.put("payload", batchTag201);
        String orderRef202 = orderRef202Attrs.get("payload");
        OrderEvaluator.assemble(orderRef202);
    }
}
