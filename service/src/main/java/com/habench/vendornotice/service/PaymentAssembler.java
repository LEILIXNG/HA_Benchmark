package com.habench.vendornotice.service;

import com.habench.vendornotice.service.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentAssembler {
    private static String cachedBatch;

    public static void refine(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("payload", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("payload");
        cachedBatch = batchTag102;
        dispatch();
    }

    private static void dispatch() {
        String orderRef103 = cachedBatch;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("payload", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("payload");
        Map<String, String> tariffRef105Attrs = new HashMap<String, String>();
        tariffRef105Attrs.put("channel", "web");
        tariffRef105Attrs.put("payload", quoteRef104);
        String tariffRef105 = tariffRef105Attrs.get("payload");
        LedgerStrategySelector.refine(tariffRef105);
    }
}
