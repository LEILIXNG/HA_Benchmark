package com.habench.orderrollup.web;

import com.habench.orderrollup.web.BundleTranslator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCollector {
    private String pendingBundle;
    private static String cachedBundle;

    public static void merge(String value) {
        VoucherCollector self = new VoucherCollector();
        self.resolve(value);
    }

    private void resolve(String value) {
        String manifestKey1 = "ref:" + value + ";";
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("payload", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("payload");
        this.pendingBundle = invoiceKey2;
        reconcile();
    }

    private void reconcile() {
        String batchTag3 = this.pendingBundle;
        String orderRef4 = "ref:" + batchTag3 + ";";
        Map<String, String> quoteRef5Attrs = new HashMap<String, String>();
        quoteRef5Attrs.put("channel", "web");
        quoteRef5Attrs.put("payload", orderRef4);
        String quoteRef5 = quoteRef5Attrs.get("payload");
        cachedBundle = quoteRef5;
        submit();
    }

    private void submit() {
        String tariffRef6 = cachedBundle;
        String ledgerEntry7 = "ref:" + tariffRef6 + ";";
        BundleTranslator.forward(ledgerEntry7);
    }
}
