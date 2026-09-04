package com.habench.cataloggrant.service;

import com.habench.cataloggrant.service.ManifestExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteComposer {
    private String pendingManifest;

    public static void submit(String value) {
        QuoteComposer self = new QuoteComposer();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> refundCode201Attrs = new HashMap<String, String>();
        refundCode201Attrs.put("channel", "web");
        refundCode201Attrs.put("payload", value);
        String refundCode201 = refundCode201Attrs.get("payload");
        this.pendingManifest = refundCode201;
        assemble();
    }

    private void assemble() {
        String shipmentCode202 = this.pendingManifest;
        String manifestKey203 = "ref:" + shipmentCode202 + ";";
        String invoiceKey204 = "ref:" + manifestKey203 + ";";
        ManifestExecutor.collect(invoiceKey204);
    }
}
