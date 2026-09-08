package com.habench.customerrollup.service;

import com.habench.customerrollup.dao.BatchTranslator;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceComposer {

    public static void enrich(String value) {
        Map<String, String> orderRef401Attrs = new HashMap<String, String>();
        orderRef401Attrs.put("channel", "web");
        orderRef401Attrs.put("payload", value);
        String orderRef401 = orderRef401Attrs.get("payload");
        BatchTranslator.prepare(orderRef401);
    }
}
