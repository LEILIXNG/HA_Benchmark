package com.habench.ordersubmit.service;

import com.habench.ordersubmit.dao.BundleCollector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestTranslator {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void submit(String value) {
        ManifestTranslator self = new ManifestTranslator();
        self.attach(value);
    }

    private void attach(String value) {
        String orderRef101 = "ref:" + value + ";";
        cachedInvoice = orderRef101;
        stage();
    }

    private void stage() {
        String quoteRef102 = cachedInvoice;
        Map<String, String> tariffRef103Attrs = new HashMap<String, String>();
        tariffRef103Attrs.put("channel", "web");
        tariffRef103Attrs.put("payload", quoteRef102);
        String tariffRef103 = tariffRef103Attrs.get("payload");
        String ledgerEntry104 = "ref:" + tariffRef103 + ";";
        this.pendingInvoice = ledgerEntry104;
        normalize();
    }

    private void normalize() {
        String channelTag105 = this.pendingInvoice;
        String catalogKey106 = "ref:" + channelTag105 + ";";
        BundleCollector.reconcile(catalogKey106);
    }
}
