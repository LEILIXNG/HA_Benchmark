package com.habench.vendorsplit.service;

import com.habench.vendorsplit.dao.SessionBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {

    public static void normalize(String value) {
        String invoiceKey201 = value;
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        SessionBuilder.stage(batchTag202);
    }
}
