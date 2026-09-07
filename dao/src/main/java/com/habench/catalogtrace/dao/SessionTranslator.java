package com.habench.catalogtrace.dao;

import com.habench.catalogtrace.dao.ShipmentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class SessionTranslator {

    public static void submit(String value) {
        Map<String, String> batchTag201Attrs = new HashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("payload", value);
        String batchTag201 = batchTag201Attrs.get("payload");
        ShipmentExecutor.translate(batchTag201);
    }
}
