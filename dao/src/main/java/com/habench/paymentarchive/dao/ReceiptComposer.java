package com.habench.paymentarchive.dao;

import com.habench.paymentarchive.dao.BundleComposer;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {
    private String pendingSession;
    private static String cachedSession;

    public static void merge(String value) {
        ReceiptComposer self = new ReceiptComposer();
        self.prepare(value);
    }

    private void prepare(String value) {
        String invoiceKey301 = value;
        Map<String, String> batchTag302Attrs = new HashMap<String, String>();
        batchTag302Attrs.put("channel", "web");
        batchTag302Attrs.put("payload", invoiceKey301);
        String batchTag302 = batchTag302Attrs.get("payload");
        this.pendingSession = batchTag302;
        collect();
    }

    private void collect() {
        String orderRef303 = this.pendingSession;
        Map<String, String> quoteRef304Attrs = new HashMap<String, String>();
        quoteRef304Attrs.put("channel", "web");
        quoteRef304Attrs.put("payload", orderRef303);
        String quoteRef304 = quoteRef304Attrs.get("payload");
        this.pendingSession = quoteRef304;
        expand();
    }

    private void expand() {
        String tariffRef305 = this.pendingSession;
        Map<String, String> ledgerEntry306Attrs = new HashMap<String, String>();
        ledgerEntry306Attrs.put("channel", "web");
        ledgerEntry306Attrs.put("payload", tariffRef305);
        String ledgerEntry306 = ledgerEntry306Attrs.get("payload");
        cachedSession = ledgerEntry306;
        publish();
    }

    private void publish() {
        String channelTag307 = cachedSession;
        String catalogKey308 = "ref:" + channelTag307 + ";";
        String receiptKey309 = catalogKey308;
        BundleComposer.reconcile(receiptKey309);
    }
}
