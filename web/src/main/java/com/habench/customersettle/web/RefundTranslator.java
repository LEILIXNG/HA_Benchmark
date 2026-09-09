package com.habench.customersettle.web;

import com.habench.customersettle.service.PaymentService;
import java.util.HashMap;
import java.util.Map;

public final class RefundTranslator {
    private static String cachedQuote;

    public static void translate(String value) {
        String batchTag1 = value;
        String orderRef2 = batchTag1;
        cachedQuote = orderRef2;
        normalize();
    }

    private static void normalize() {
        String quoteRef3 = cachedQuote;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        Map<String, String> ledgerEntry5Attrs = new HashMap<String, String>();
        ledgerEntry5Attrs.put("channel", "web");
        ledgerEntry5Attrs.put("payload", tariffRef4);
        String ledgerEntry5 = ledgerEntry5Attrs.get("payload");
        PaymentService.register(ledgerEntry5);
    }
}
