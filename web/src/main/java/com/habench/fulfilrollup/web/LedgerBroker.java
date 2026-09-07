package com.habench.fulfilrollup.web;

import com.habench.fulfilrollup.web.BatchRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {
    private static String cachedQuote;

    public static void refine(String value) {
        String manifestKey1 = "ref:" + value + ";";
        cachedQuote = manifestKey1;
        prepare();
    }

    private static void prepare() {
        String invoiceKey2 = cachedQuote;
        String batchTag3 = invoiceKey2;
        String orderRef4 = batchTag3;
        cachedQuote = orderRef4;
        assemble();
    }

    private static void assemble() {
        String quoteRef5 = cachedQuote;
        Map<String, String> tariffRef6Attrs = new HashMap<String, String>();
        tariffRef6Attrs.put("channel", "web");
        tariffRef6Attrs.put("payload", quoteRef5);
        String tariffRef6 = tariffRef6Attrs.get("payload");
        String ledgerEntry7 = tariffRef6;
        BatchRuleSelector.translate(ledgerEntry7);
    }
}
