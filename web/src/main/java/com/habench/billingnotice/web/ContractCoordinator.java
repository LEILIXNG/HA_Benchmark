package com.habench.billingnotice.web;

import com.habench.billingnotice.service.TariffEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ContractCoordinator {
    private static String cachedQuote;

    public static void expand(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        String orderRef2 = batchTag1;
        cachedQuote = orderRef2;
        translate();
    }

    private static void translate() {
        String quoteRef3 = cachedQuote;
        String tariffRef4 = quoteRef3;
        String ledgerEntry5 = tariffRef4;
        cachedQuote = ledgerEntry5;
        normalize();
    }

    private static void normalize() {
        String channelTag6 = cachedQuote;
        String catalogKey7 = "ref:" + channelTag6 + ";";
        TariffEnricher.register(catalogKey7);
    }
}
