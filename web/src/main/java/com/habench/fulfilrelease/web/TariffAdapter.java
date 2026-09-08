package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.service.SessionNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class TariffAdapter {
    private static String cachedPayment;

    public static void stage(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedPayment = quoteRef2;
        enrich();
    }

    private static void enrich() {
        String tariffRef3 = cachedPayment;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        SessionNormalizer.collect(channelTag5);
    }
}
