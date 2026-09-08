package com.habench.pricingrollup.web;

import com.habench.pricingrollup.web.OrderBroker;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {
    private static String cachedChannel;

    public static void enrich(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("payload", value);
        String batchTag1 = batchTag1Attrs.get("payload");
        String orderRef2 = batchTag1;
        cachedChannel = orderRef2;
        merge();
    }

    private static void merge() {
        String quoteRef3 = cachedChannel;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("payload", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("payload");
        OrderBroker.refine(ledgerEntry5);
    }
}
