package com.habench.shippingrenewal.web;

import com.habench.shippingrenewal.web.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ChannelRegistry {
    private static String cachedRefund;

    public static void stage(String value) {
        Map<String, String> ledgerEntry201Attrs = new HashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("payload", value);
        String ledgerEntry201 = ledgerEntry201Attrs.get("payload");
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        cachedRefund = channelTag202;
        merge();
    }

    private static void merge() {
        String catalogKey203 = cachedRefund;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        CatalogRegistry.dispatch(receiptKey204);
    }
}
