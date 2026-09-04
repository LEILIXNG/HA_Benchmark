package com.habench.paymentdraft.service;

import com.habench.paymentdraft.service.BatchExecutor;
import java.util.HashMap;
import java.util.Map;

public final class BatchCoordinator {
    private static String cachedBatch;

    public static void merge(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        cachedBatch = manifestKey202;
        collect();
    }

    private static void collect() {
        String invoiceKey203 = cachedBatch;
        Map<String, String> batchTag204Attrs = new HashMap<String, String>();
        batchTag204Attrs.put("channel", "web");
        batchTag204Attrs.put("payload", invoiceKey203);
        String batchTag204 = batchTag204Attrs.get("payload");
        String orderRef205 = "ref:" + batchTag204 + ";";
        BatchExecutor.forward(orderRef205);
    }
}
