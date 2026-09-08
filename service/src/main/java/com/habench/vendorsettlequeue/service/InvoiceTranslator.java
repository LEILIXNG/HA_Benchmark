package com.habench.vendorsettlequeue.service;

import com.habench.vendorsettlequeue.service.OrderGateway;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceTranslator {

    public static void route(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        OrderGateway.register(batchTag201);
    }
}
