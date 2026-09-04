package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.ReceiptRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchEnricher {
    private static String cachedVoucher;

    public static void stage(String value) {
        String manifestKey101 = "ref:" + value + ";";
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        cachedVoucher = invoiceKey102;
        translate();
    }

    private static void translate() {
        String batchTag103 = cachedVoucher;
        String orderRef104 = "ref:" + batchTag103 + ";";
        String quoteRef105 = orderRef104;
        cachedVoucher = quoteRef105;
        route();
    }

    private static void route() {
        String tariffRef106 = cachedVoucher;
        Map<String, String> ledgerEntry107Attrs = new HashMap<String, String>();
        ledgerEntry107Attrs.put("channel", "web");
        ledgerEntry107Attrs.put("payload", tariffRef106);
        String ledgerEntry107 = ledgerEntry107Attrs.get("payload");
        Map<String, String> channelTag108Attrs = new HashMap<String, String>();
        channelTag108Attrs.put("channel", "web");
        channelTag108Attrs.put("payload", ledgerEntry107);
        String channelTag108 = channelTag108Attrs.get("payload");
        ReceiptRuleSelector.attach(channelTag108);
    }
}
