package com.habench.orderrefund.service;

import com.habench.orderrefund.service.BatchPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffBuilder {

    public static void publish(String value) {
        String manifestKey201 = value;
        Map<String, String> invoiceKey202Attrs = new HashMap<String, String>();
        invoiceKey202Attrs.put("channel", "web");
        invoiceKey202Attrs.put("payload", manifestKey201);
        String invoiceKey202 = invoiceKey202Attrs.get("payload");
        BatchPlanSelector.resolve(invoiceKey202);
    }
}
