package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.web.PaymentRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCollector {
    private String pendingContract;
    private static String cachedContract;

    public static void assemble(String value) {
        LedgerCollector self = new LedgerCollector();
        self.forward(value);
    }

    private void forward(String value) {
        String orderRef1 = "ref:" + value + ";";
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("payload", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("payload");
        cachedContract = quoteRef2;
        collect();
    }

    private void collect() {
        String tariffRef3 = cachedContract;
        String ledgerEntry4 = "ref:" + tariffRef3 + ";";
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("payload", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("payload");
        this.pendingContract = channelTag5;
        enrich();
    }

    private void enrich() {
        String catalogKey6 = this.pendingContract;
        String receiptKey7 = "ref:" + catalogKey6 + ";";
        PaymentRuleSelector.reconcile(receiptKey7);
    }
}
