package com.habench.fulfilgrant.service;

import com.habench.fulfilgrant.service.ReceiptExecutor;
import java.util.HashMap;
import java.util.Map;

public final class LedgerNormalizer {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void expand(String value) {
        LedgerNormalizer self = new LedgerNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        String manifestKey301 = value;
        cachedReceipt = manifestKey301;
        normalize();
    }

    private void normalize() {
        String invoiceKey302 = cachedReceipt;
        Map<String, String> batchTag303Attrs = new HashMap<String, String>();
        batchTag303Attrs.put("channel", "web");
        batchTag303Attrs.put("payload", invoiceKey302);
        String batchTag303 = batchTag303Attrs.get("payload");
        this.pendingReceipt = batchTag303;
        assemble();
    }

    private void assemble() {
        String orderRef304 = this.pendingReceipt;
        String quoteRef305 = "ref:" + orderRef304 + ";";
        String tariffRef306 = "ref:" + quoteRef305 + ";";
        ReceiptExecutor.refine(tariffRef306);
    }
}
