package com.habench.paymentsettlequeue.web;

import com.habench.paymentsettlequeue.service.VoucherTranslator;
import java.util.HashMap;
import java.util.Map;

public final class CatalogEnricher {
    private String pendingSession;

    public static void refine(String value) {
        CatalogEnricher self = new CatalogEnricher();
        self.translate(value);
    }

    private void translate(String value) {
        String manifestKey1 = "ref:" + value + ";";
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        this.pendingSession = invoiceKey2;
        enrich();
    }

    private void enrich() {
        String batchTag3 = this.pendingSession;
        String orderRef4 = "ref:" + batchTag3 + ";";
        VoucherTranslator.expand(orderRef4);
    }
}
