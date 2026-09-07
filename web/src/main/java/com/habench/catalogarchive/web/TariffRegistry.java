package com.habench.catalogarchive.web;

import com.habench.catalogarchive.web.RefundRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffRegistry {
    private static String cachedShipment;

    public static void collect(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        cachedShipment = batchTag2;
        enrich();
    }

    private static void enrich() {
        String orderRef3 = cachedShipment;
        Map<String, String> quoteRef4Attrs = new HashMap<String, String>();
        quoteRef4Attrs.put("channel", "web");
        quoteRef4Attrs.put("payload", orderRef3);
        String quoteRef4 = quoteRef4Attrs.get("payload");
        String tariffRef5 = "ref:" + quoteRef4 + ";";
        RefundRuleSelector.resolve(tariffRef5);
    }
}
