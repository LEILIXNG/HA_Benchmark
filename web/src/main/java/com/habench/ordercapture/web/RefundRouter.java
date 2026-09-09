package com.habench.ordercapture.web;

import com.habench.ordercapture.web.InvoiceRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class RefundRouter {
    private String pendingSession;
    private static String cachedSession;

    public static void enrich(String value) {
        RefundRouter self = new RefundRouter();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedSession = quoteRef1;
        expand();
    }

    private void expand() {
        String tariffRef2 = cachedSession;
        Map<String, String> ledgerEntry3Attrs = new HashMap<String, String>();
        ledgerEntry3Attrs.put("channel", "web");
        ledgerEntry3Attrs.put("payload", tariffRef2);
        String ledgerEntry3 = ledgerEntry3Attrs.get("payload");
        this.pendingSession = ledgerEntry3;
        prepare();
    }

    private void prepare() {
        String channelTag4 = this.pendingSession;
        Map<String, String> catalogKey5Attrs = new HashMap<String, String>();
        catalogKey5Attrs.put("channel", "web");
        catalogKey5Attrs.put("payload", channelTag4);
        String catalogKey5 = catalogKey5Attrs.get("payload");
        Map<String, String> receiptKey6Attrs = new HashMap<String, String>();
        receiptKey6Attrs.put("channel", "web");
        receiptKey6Attrs.put("payload", catalogKey5);
        String receiptKey6 = receiptKey6Attrs.get("payload");
        InvoiceRuleSelector.prepare(receiptKey6);
    }
}
