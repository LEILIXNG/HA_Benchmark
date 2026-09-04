package com.habench.inventorybind.web;

import com.habench.inventorybind.service.ManifestTranslator;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {
    private String pendingPayment;

    public static void reconcile(String value) {
        ManifestResolver self = new ManifestResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        String batchTag1 = value;
        this.pendingPayment = batchTag1;
        resolve();
    }

    private void resolve() {
        String orderRef2 = this.pendingPayment;
        String quoteRef3 = orderRef2;
        Map<String, String> tariffRef4Attrs = new HashMap<String, String>();
        tariffRef4Attrs.put("channel", "web");
        tariffRef4Attrs.put("payload", quoteRef3);
        String tariffRef4 = tariffRef4Attrs.get("payload");
        ManifestTranslator.refine(tariffRef4);
    }
}
