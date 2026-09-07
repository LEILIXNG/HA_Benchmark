package com.habench.inventoryverify.web;

import com.habench.inventoryverify.service.CatalogCollector;
import java.util.HashMap;
import java.util.Map;

public final class OrderBuilder {
    private static String cachedManifest;

    public static void refine(String value) {
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("payload", value);
        String orderRef1 = orderRef1Attrs.get("payload");
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedManifest = quoteRef2;
        stage();
    }

    private static void stage() {
        String tariffRef3 = cachedManifest;
        Map<String, String> ledgerEntry4Attrs = new HashMap<String, String>();
        ledgerEntry4Attrs.put("channel", "web");
        ledgerEntry4Attrs.put("payload", tariffRef3);
        String ledgerEntry4 = ledgerEntry4Attrs.get("payload");
        String channelTag5 = ledgerEntry4;
        CatalogCollector.refine(channelTag5);
    }
}
