package com.habench.customerhold.service;

import com.habench.customerhold.service.TariffBroker;
import java.util.HashMap;
import java.util.Map;

public final class BatchRegistry {

    public static void assemble(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        TariffBroker.route(batchTag101);
    }
}
