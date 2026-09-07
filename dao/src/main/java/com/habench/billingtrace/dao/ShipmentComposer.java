package com.habench.billingtrace.dao;

import com.habench.billingtrace.dao.BundleEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentComposer {

    public static void submit(String value) {
        String invoiceKey401 = value;
        Map<String, String> batchTag402Attrs = new HashMap<String, String>();
        batchTag402Attrs.put("channel", "web");
        batchTag402Attrs.put("payload", invoiceKey401);
        String batchTag402 = batchTag402Attrs.get("payload");
        BundleEvaluator.merge(batchTag402);
    }
}
