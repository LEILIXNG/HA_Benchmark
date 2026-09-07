package com.habench.billingrevise.web;

import com.habench.billingrevise.service.OrderCollector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptEnricher {
    private static String cachedChannel;

    public static void resolve(String value) {
        String batchTag1 = "ref:" + value + ";";
        Map<String, String> orderRef2Attrs = new HashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("payload", batchTag1);
        String orderRef2 = orderRef2Attrs.get("payload");
        cachedChannel = orderRef2;
        normalize();
    }

    private static void normalize() {
        String quoteRef3 = cachedChannel;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        cachedChannel = tariffRef4;
        enrich();
    }

    private static void enrich() {
        String ledgerEntry5 = cachedChannel;
        Map<String, String> channelTag6Attrs = new HashMap<String, String>();
        channelTag6Attrs.put("channel", "web");
        channelTag6Attrs.put("payload", ledgerEntry5);
        String channelTag6 = channelTag6Attrs.get("payload");
        String catalogKey7 = channelTag6;
        OrderCollector.merge(catalogKey7);
    }
}
