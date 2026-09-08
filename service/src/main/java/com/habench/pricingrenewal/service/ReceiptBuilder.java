package com.habench.pricingrenewal.service;

import com.habench.pricingrenewal.service.QuoteValidator;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBuilder {
    private String pendingLedger;

    public static void merge(String value) {
        ReceiptBuilder self = new ReceiptBuilder();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef101 = value;
        String quoteRef102 = orderRef101;
        this.pendingLedger = quoteRef102;
        route();
    }

    private void route() {
        String tariffRef103 = this.pendingLedger;
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        this.pendingLedger = ledgerEntry104;
        dispatch();
    }

    private void dispatch() {
        String channelTag105 = this.pendingLedger;
        Map<String, String> catalogKey106Attrs = new HashMap<String, String>();
        catalogKey106Attrs.put("channel", "web");
        catalogKey106Attrs.put("payload", channelTag105);
        String catalogKey106 = catalogKey106Attrs.get("payload");
        Map<String, String> receiptKey107Attrs = new HashMap<String, String>();
        receiptKey107Attrs.put("channel", "web");
        receiptKey107Attrs.put("payload", catalogKey106);
        String receiptKey107 = receiptKey107Attrs.get("payload");
        QuoteValidator.compose(receiptKey107);
    }
}
