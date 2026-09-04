package com.habench.reportrenewal.service;

import com.habench.reportrenewal.service.ManifestPolicy;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private static String cachedPayment;

    public static void normalize(String value) {
        String ledgerEntry101 = "ref:" + value + ";";
        Map<String, String> channelTag102Attrs = new HashMap<String, String>();
        channelTag102Attrs.put("channel", "web");
        channelTag102Attrs.put("payload", ledgerEntry101);
        String channelTag102 = channelTag102Attrs.get("payload");
        cachedPayment = channelTag102;
        assemble();
    }

    private static void assemble() {
        String catalogKey103 = cachedPayment;
        String receiptKey104 = "ref:" + catalogKey103 + ";";
        ManifestPolicy.dispatch(receiptKey104);
    }
}
