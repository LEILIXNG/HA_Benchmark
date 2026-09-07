package com.habench.reportposting.service;

import com.habench.reportposting.service.RefundPolicy;
import java.util.HashMap;
import java.util.Map;

public final class ChannelCoordinator {
    private String pendingManifest;
    private static String cachedManifest;

    public static void reconcile(String value) {
        ChannelCoordinator self = new ChannelCoordinator();
        self.refine(value);
    }

    private void refine(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        cachedManifest = manifestKey202;
        publish();
    }

    private void publish() {
        String invoiceKey203 = cachedManifest;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        this.pendingManifest = batchTag204;
        attach();
    }

    private void attach() {
        String orderRef205 = this.pendingManifest;
        Map<String, String> quoteRef206Attrs = new HashMap<String, String>();
        quoteRef206Attrs.put("channel", "web");
        quoteRef206Attrs.put("payload", orderRef205);
        String quoteRef206 = quoteRef206Attrs.get("payload");
        RefundPolicy.route(quoteRef206);
    }
}
