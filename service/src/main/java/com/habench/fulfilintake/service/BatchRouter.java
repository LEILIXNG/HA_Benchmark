package com.habench.fulfilintake.service;

import com.habench.fulfilintake.service.CatalogPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchRouter {
    private String pendingSession;
    private static String cachedSession;

    public static void assemble(String value) {
        BatchRouter self = new BatchRouter();
        self.submit(value);
    }

    private void submit(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        this.pendingSession = shipmentCode201;
        register();
    }

    private void register() {
        String manifestKey202 = this.pendingSession;
        Map<String, String> invoiceKey203Attrs = new HashMap<String, String>();
        invoiceKey203Attrs.put("channel", "web");
        invoiceKey203Attrs.put("payload", manifestKey202);
        String invoiceKey203 = invoiceKey203Attrs.get("payload");
        Map<String, String> batchTag204Attrs = new HashMap<String, String>();
        batchTag204Attrs.put("channel", "web");
        batchTag204Attrs.put("payload", invoiceKey203);
        String batchTag204 = batchTag204Attrs.get("payload");
        cachedSession = batchTag204;
        resolve();
    }

    private void resolve() {
        String orderRef205 = cachedSession;
        Map<String, String> quoteRef206Attrs = new HashMap<String, String>();
        quoteRef206Attrs.put("channel", "web");
        quoteRef206Attrs.put("payload", orderRef205);
        String quoteRef206 = quoteRef206Attrs.get("payload");
        CatalogPolicySelector.attach(quoteRef206);
    }
}
