package com.habench.pricingmanifest.web;

import com.habench.pricingmanifest.web.ContractBuilder;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {
    private static String cachedQuote;

    public static void stage(String value) {
        String orderRef1 = value;
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedQuote = quoteRef2;
        enrich();
    }

    private static void enrich() {
        String tariffRef3 = cachedQuote;
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        ContractBuilder.publish(channelTag5);
    }
}
