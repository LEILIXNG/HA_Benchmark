package com.habench.pricingmerge.dao;

import com.habench.pricingmerge.dao.SessionRegistry;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceTranslator {
    private String pendingManifest;
    private static String cachedManifest;

    public static void stage(String value) {
        InvoiceTranslator self = new InvoiceTranslator();
        self.collect(value);
    }

    private void collect(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        this.pendingManifest = shipmentCode201;
        reconcile();
    }

    private void reconcile() {
        String manifestKey202 = this.pendingManifest;
        Map<String, String> invoiceKey203Attrs = new HashMap<String, String>();
        invoiceKey203Attrs.put("channel", "web");
        invoiceKey203Attrs.put("payload", manifestKey202);
        String invoiceKey203 = invoiceKey203Attrs.get("payload");
        cachedManifest = invoiceKey203;
        attach();
    }

    private void attach() {
        String batchTag204 = cachedManifest;
        String orderRef205 = "ref:" + batchTag204 + ";";
        String quoteRef206 = orderRef205;
        SessionRegistry.attach(quoteRef206);
    }
}
