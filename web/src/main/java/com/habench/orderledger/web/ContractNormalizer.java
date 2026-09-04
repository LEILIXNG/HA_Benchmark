package com.habench.orderledger.web;

import com.habench.orderledger.web.LedgerStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {
    private static String cachedSession;

    public static void resolve(String value) {
        Map<String, String> paymentTag1Attrs = new HashMap<String, String>();
        paymentTag1Attrs.put("channel", "web");
        paymentTag1Attrs.put("payload", value);
        String paymentTag1 = paymentTag1Attrs.get("payload");
        Map<String, String> refundCode2Attrs = new HashMap<String, String>();
        refundCode2Attrs.put("channel", "web");
        refundCode2Attrs.put("payload", paymentTag1);
        String refundCode2 = refundCode2Attrs.get("payload");
        cachedSession = refundCode2;
        enrich();
    }

    private static void enrich() {
        String shipmentCode3 = cachedSession;
        Map<String, String> manifestKey4Attrs = new HashMap<String, String>();
        manifestKey4Attrs.put("channel", "web");
        manifestKey4Attrs.put("payload", shipmentCode3);
        String manifestKey4 = manifestKey4Attrs.get("payload");
        String invoiceKey5 = manifestKey4;
        LedgerStrategySelector.enrich(invoiceKey5);
    }
}
