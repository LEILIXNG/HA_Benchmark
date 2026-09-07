package com.habench.customerquote.web;

import com.habench.customerquote.web.BundleTranslator;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {
    private static String cachedShipment;

    public static void collect(String value) {
        String orderRef1 = value;
        String quoteRef2 = "ref:" + orderRef1 + ";";
        cachedShipment = quoteRef2;
        enrich();
    }

    private static void enrich() {
        String tariffRef3 = cachedShipment;
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        BundleTranslator.enrich(channelTag5);
    }
}
