package com.habench.shippinggrant.service;

import com.habench.shippinggrant.service.OrderFilter;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceResolver {

    public static void normalize(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        OrderFilter.merge(batchTag101);
    }
}
