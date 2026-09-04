package com.habench.customermerge.web;

import com.habench.customermerge.web.LedgerRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundRegistry {
    private static String cachedAccount;

    public static void merge(String value) {
        String manifestKey1 = value;
        cachedAccount = manifestKey1;
        enrich();
    }

    private static void enrich() {
        String invoiceKey2 = cachedAccount;
        Map<String, String> batchTag3Attrs = new HashMap<String, String>();
        batchTag3Attrs.put("channel", "web");
        batchTag3Attrs.put("payload", invoiceKey2);
        String batchTag3 = batchTag3Attrs.get("payload");
        cachedAccount = batchTag3;
        submit();
    }

    private static void submit() {
        String orderRef4 = cachedAccount;
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        LedgerRuleSelector.forward(quoteRef5);
    }
}
