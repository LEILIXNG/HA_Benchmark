package com.habench.orderbatch.service;

import com.habench.orderbatch.service.OrderEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {

    public static void merge(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        String orderRef202 = batchTag201;
        OrderEvaluator.submit(orderRef202);
    }
}
