package com.habench.fulfilgrant.service;

import com.habench.fulfilgrant.service.SessionGuard;
import java.util.HashMap;
import java.util.Map;

public final class CatalogNormalizer {
    private String pendingChannel;

    public static void route(String value) {
        CatalogNormalizer self = new CatalogNormalizer();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> manifestKey101Attrs = new HashMap<String, String>();
        manifestKey101Attrs.put("channel", "web");
        manifestKey101Attrs.put("payload", value);
        String manifestKey101 = manifestKey101Attrs.get("payload");
        this.pendingChannel = manifestKey101;
        submit();
    }

    private void submit() {
        String invoiceKey102 = this.pendingChannel;
        Map<String, String> batchTag103Attrs = new HashMap<String, String>();
        batchTag103Attrs.put("channel", "web");
        batchTag103Attrs.put("payload", invoiceKey102);
        String batchTag103 = batchTag103Attrs.get("payload");
        SessionGuard.normalize(batchTag103);
    }
}
