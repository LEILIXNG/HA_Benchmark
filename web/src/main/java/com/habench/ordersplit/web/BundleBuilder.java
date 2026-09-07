package com.habench.ordersplit.web;

import com.habench.ordersplit.web.ChannelGuard;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private static String cachedReceipt;

    public static void enrich(String value) {
        String batchTag1 = "ref:" + value + ";";
        String orderRef2 = "ref:" + batchTag1 + ";";
        cachedReceipt = orderRef2;
        stage();
    }

    private static void stage() {
        String quoteRef3 = cachedReceipt;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        cachedReceipt = tariffRef4;
        assemble();
    }

    private static void assemble() {
        String ledgerEntry5 = cachedReceipt;
        String channelTag6 = "ref:" + ledgerEntry5 + ";";
        ChannelGuard.prepare(channelTag6);
    }
}
