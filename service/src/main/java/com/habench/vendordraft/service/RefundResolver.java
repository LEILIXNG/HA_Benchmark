package com.habench.vendordraft.service;

import com.habench.vendordraft.service.InvoiceBroker;
import java.util.HashMap;
import java.util.Map;

public final class RefundResolver {
    private String pendingManifest;
    private static String cachedManifest;

    public static void reconcile(String value) {
        RefundResolver self = new RefundResolver();
        self.submit(value);
    }

    private void submit(String value) {
        String refundCode201 = "ref:" + value + ";";
        cachedManifest = refundCode201;
        resolve();
    }

    private void resolve() {
        String shipmentCode202 = cachedManifest;
        Map<String, String> manifestKey203Attrs = new HashMap<String, String>();
        manifestKey203Attrs.put("channel", "web");
        manifestKey203Attrs.put("payload", shipmentCode202);
        String manifestKey203 = manifestKey203Attrs.get("payload");
        this.pendingManifest = manifestKey203;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey204 = this.pendingManifest;
        Map<String, String> batchTag205Attrs = new HashMap<String, String>();
        batchTag205Attrs.put("channel", "web");
        batchTag205Attrs.put("payload", invoiceKey204);
        String batchTag205 = batchTag205Attrs.get("payload");
        InvoiceBroker.resolve(batchTag205);
    }
}
