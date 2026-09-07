package com.habench.paymentrevise.web;

import com.habench.paymentrevise.service.ManifestAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptEnricher {
    private static String cachedInvoice;

    public static void enrich(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        cachedInvoice = batchTag1;
        collect();
    }

    private static void collect() {
        String orderRef2 = cachedInvoice;
        String quoteRef3 = orderRef2;
        cachedInvoice = quoteRef3;
        dispatch();
    }

    private static void dispatch() {
        String tariffRef4 = cachedInvoice;
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("payload", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("payload");
        ManifestAssembler.dispatch(ledgerEntry5);
    }
}
