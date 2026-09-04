package com.habench.billinghold.web;

import com.habench.billinghold.service.ManifestEnricher;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRouter {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void resolve(String value) {
        LedgerRouter self = new LedgerRouter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String manifestKey101 = "ref:" + value + ";";
        Map<String, String> invoiceKey102Attrs = new HashMap<String, String>();
        invoiceKey102Attrs.put("channel", "web");
        invoiceKey102Attrs.put("payload", manifestKey101);
        String invoiceKey102 = invoiceKey102Attrs.get("payload");
        cachedReceipt = invoiceKey102;
        compose();
    }

    private void compose() {
        String batchTag103 = cachedReceipt;
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("payload", batchTag103);
        String orderRef104 = orderRef104Attrs.get("payload");
        this.pendingReceipt = orderRef104;
        translate();
    }

    private void translate() {
        String quoteRef105 = this.pendingReceipt;
        Map<String, String> tariffRef106Attrs = new HashMap<String, String>();
        tariffRef106Attrs.put("channel", "web");
        tariffRef106Attrs.put("payload", quoteRef105);
        String tariffRef106 = tariffRef106Attrs.get("payload");
        cachedReceipt = tariffRef106;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry107 = cachedReceipt;
        Map<String, String> channelTag108Attrs = new HashMap<String, String>();
        channelTag108Attrs.put("channel", "web");
        channelTag108Attrs.put("payload", ledgerEntry107);
        String channelTag108 = channelTag108Attrs.get("payload");
        cachedReceipt = channelTag108;
        collect();
    }

    private void collect() {
        String catalogKey109 = cachedReceipt;
        String receiptKey110 = catalogKey109;
        ManifestEnricher.register(receiptKey110);
    }
}
