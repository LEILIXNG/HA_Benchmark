package com.habench.vendorposting.web;

import com.habench.vendorposting.web.ManifestRegistry;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceEnricher {
    private static String cachedBundle;

    public static void submit(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("payload", value);
        String invoiceKey1 = invoiceKey1Attrs.get("payload");
        cachedBundle = invoiceKey1;
        dispatch();
    }

    private static void dispatch() {
        String batchTag2 = cachedBundle;
        Map<String, String> orderRef3Attrs = new HashMap<String, String>();
        orderRef3Attrs.put("channel", "web");
        orderRef3Attrs.put("payload", batchTag2);
        String orderRef3 = orderRef3Attrs.get("payload");
        String quoteRef4 = orderRef3;
        cachedBundle = quoteRef4;
        reconcile();
    }

    private static void reconcile() {
        String tariffRef5 = cachedBundle;
        String ledgerEntry6 = tariffRef5;
        Map<String, String> channelTag7Attrs = new HashMap<String, String>();
        channelTag7Attrs.put("channel", "web");
        channelTag7Attrs.put("payload", ledgerEntry6);
        String channelTag7 = channelTag7Attrs.get("payload");
        cachedBundle = channelTag7;
        publish();
    }

    private static void publish() {
        String catalogKey8 = cachedBundle;
        Map<String, String> receiptKey9Attrs = new HashMap<String, String>();
        receiptKey9Attrs.put("channel", "web");
        receiptKey9Attrs.put("payload", catalogKey8);
        String receiptKey9 = receiptKey9Attrs.get("payload");
        ManifestRegistry.publish(receiptKey9);
    }
}
