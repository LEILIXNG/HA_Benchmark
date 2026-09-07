package com.habench.reportgrant.web;

import com.habench.reportgrant.web.OrderLoader;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCollector {
    private static String cachedOrder;

    public static void compose(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        String tariffRef2 = "ref:" + quoteRef1 + ";";
        cachedOrder = tariffRef2;
        register();
    }

    private static void register() {
        String ledgerEntry3 = cachedOrder;
        String channelTag4 = ledgerEntry3;
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        cachedOrder = catalogKey5;
        translate();
    }

    private static void translate() {
        String receiptKey6 = cachedOrder;
        String accountRef7 = receiptKey6;
        OrderLoader.assemble(accountRef7);
    }
}
