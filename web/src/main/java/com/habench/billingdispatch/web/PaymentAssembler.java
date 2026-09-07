package com.habench.billingdispatch.web;

import com.habench.billingdispatch.service.OrderEnricher;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {

    public static void merge(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        OrderEnricher.dispatch(batchTag101);
    }
}
