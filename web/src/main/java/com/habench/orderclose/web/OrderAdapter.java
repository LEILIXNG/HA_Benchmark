package com.habench.orderclose.web;

import com.habench.orderclose.service.InvoiceEnricher;
import java.util.HashMap;
import java.util.Map;

public final class OrderAdapter {
    private String pendingManifest;
    private static String cachedManifest;

    public static void route(String value) {
        OrderAdapter self = new OrderAdapter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String manifestKey1 = value;
        this.pendingManifest = manifestKey1;
        merge();
    }

    private void merge() {
        String invoiceKey2 = this.pendingManifest;
        String batchTag3 = invoiceKey2;
        this.pendingManifest = batchTag3;
        translate();
    }

    private void translate() {
        String orderRef4 = this.pendingManifest;
        String quoteRef5 = "ref:" + orderRef4 + ";";
        cachedManifest = quoteRef5;
        attach();
    }

    private void attach() {
        String tariffRef6 = cachedManifest;
        String ledgerEntry7 = "ref:" + tariffRef6 + ";";
        String channelTag8 = ledgerEntry7;
        cachedManifest = channelTag8;
        forward();
    }

    private void forward() {
        String catalogKey9 = cachedManifest;
        Map<String, String> receiptKey10Attrs = new HashMap<String, String>();
        receiptKey10Attrs.put("channel", "web");
        receiptKey10Attrs.put("payload", catalogKey9);
        String receiptKey10 = receiptKey10Attrs.get("payload");
        InvoiceEnricher.enrich(receiptKey10);
    }
}
