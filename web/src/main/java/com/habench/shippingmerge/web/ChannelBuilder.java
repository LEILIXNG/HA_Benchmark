package com.habench.shippingmerge.web;

import com.habench.shippingmerge.service.BatchNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBuilder {
    private static String cachedAccount;

    public static void merge(String value) {
        String quoteRef101 = value;
        cachedAccount = quoteRef101;
        translate();
    }

    private static void translate() {
        String tariffRef102 = cachedAccount;
        Map<String, String> ledgerEntry103Attrs = new HashMap<String, String>();
        ledgerEntry103Attrs.put("channel", "web");
        ledgerEntry103Attrs.put("payload", tariffRef102);
        String ledgerEntry103 = ledgerEntry103Attrs.get("payload");
        Map<String, String> channelTag104Attrs = new HashMap<String, String>();
        channelTag104Attrs.put("channel", "web");
        channelTag104Attrs.put("payload", ledgerEntry103);
        String channelTag104 = channelTag104Attrs.get("payload");
        BatchNormalizer.merge(channelTag104);
    }
}
