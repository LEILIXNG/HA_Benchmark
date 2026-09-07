package com.habench.catalogtrace.service;

import com.habench.catalogtrace.service.BatchEvaluator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestNormalizer {
    private static String cachedBatch;

    public static void enrich(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        cachedBatch = batchTag102;
        register();
    }

    private static void register() {
        String orderRef103 = cachedBatch;
        String quoteRef104 = orderRef103;
        cachedBatch = quoteRef104;
        collect();
    }

    private static void collect() {
        String tariffRef105 = cachedBatch;
        Map<String, String> ledgerEntry106Attrs = new HashMap<String, String>();
        ledgerEntry106Attrs.put("channel", "web");
        ledgerEntry106Attrs.put("payload", tariffRef105);
        String ledgerEntry106 = ledgerEntry106Attrs.get("payload");
        String channelTag107 = ledgerEntry106;
        BatchEvaluator.expand(channelTag107);
    }
}
