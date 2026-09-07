package com.habench.orderdraft.web;

import com.habench.orderdraft.web.InvoiceStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {
    private static String cachedSession;

    public static void refine(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        cachedSession = batchTag2;
        register();
    }

    private static void register() {
        String orderRef3 = cachedSession;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        cachedSession = quoteRef4;
        merge();
    }

    private static void merge() {
        String tariffRef5 = cachedSession;
        Map<String, String> ledgerEntry6Attrs = new HashMap<String, String>();
        ledgerEntry6Attrs.put("channel", "web");
        ledgerEntry6Attrs.put("payload", tariffRef5);
        String ledgerEntry6 = ledgerEntry6Attrs.get("payload");
        Map<String, String> channelTag7Attrs = new HashMap<String, String>();
        channelTag7Attrs.put("channel", "web");
        channelTag7Attrs.put("payload", ledgerEntry6);
        String channelTag7 = channelTag7Attrs.get("payload");
        InvoiceStrategySelector.translate(channelTag7);
    }
}
