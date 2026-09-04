package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.web.ShipmentCollector;
import java.util.HashMap;
import java.util.Map;

public final class ContractFacade {
    private static String cachedQuote;

    public static void register(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        Map<String, String> batchTag2Attrs = new HashMap<String, String>();
        batchTag2Attrs.put("channel", "web");
        batchTag2Attrs.put("payload", invoiceKey1);
        String batchTag2 = batchTag2Attrs.get("payload");
        cachedQuote = batchTag2;
        publish();
    }

    private static void publish() {
        String orderRef3 = cachedQuote;
        String quoteRef4 = "ref:" + orderRef3 + ";";
        ShipmentCollector.collect(quoteRef4);
    }
}
