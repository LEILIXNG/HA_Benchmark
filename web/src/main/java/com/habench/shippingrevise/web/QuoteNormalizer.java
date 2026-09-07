package com.habench.shippingrevise.web;

import com.habench.shippingrevise.service.ChannelCollector;
import java.util.HashMap;
import java.util.Map;

public final class QuoteNormalizer {
    private static String cachedOrder;

    public static void attach(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        Map<String, String> channelTag202Attrs = new HashMap<String, String>();
        channelTag202Attrs.put("channel", "web");
        channelTag202Attrs.put("payload", ledgerEntry201);
        String channelTag202 = channelTag202Attrs.get("payload");
        cachedOrder = channelTag202;
        register();
    }

    private static void register() {
        String catalogKey203 = cachedOrder;
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        String accountRef205 = receiptKey204;
        ChannelCollector.expand(accountRef205);
    }
}
