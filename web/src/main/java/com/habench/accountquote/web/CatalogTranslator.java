package com.habench.accountquote.web;

import com.habench.accountquote.web.ManifestRepository;
import java.util.HashMap;
import java.util.Map;

public final class CatalogTranslator {
    private String pendingManifest;
    private static String cachedManifest;

    public static void collect(String value) {
        CatalogTranslator self = new CatalogTranslator();
        self.attach(value);
    }

    private void attach(String value) {
        String shipmentCode1 = value;
        cachedManifest = shipmentCode1;
        prepare();
    }

    private void prepare() {
        String manifestKey2 = cachedManifest;
        Map<String, String> invoiceKey3Attrs = new HashMap<String, String>();
        invoiceKey3Attrs.put("channel", "web");
        invoiceKey3Attrs.put("payload", manifestKey2);
        String invoiceKey3 = invoiceKey3Attrs.get("payload");
        String batchTag4 = invoiceKey3;
        this.pendingManifest = batchTag4;
        reconcile();
    }

    private void reconcile() {
        String orderRef5 = this.pendingManifest;
        String quoteRef6 = orderRef5;
        String tariffRef7 = quoteRef6;
        ManifestRepository.refine(tariffRef7);
    }
}
