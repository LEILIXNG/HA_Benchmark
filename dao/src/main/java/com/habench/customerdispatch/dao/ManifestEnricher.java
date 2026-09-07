package com.habench.customerdispatch.dao;

import com.habench.customerdispatch.dao.BundleRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestEnricher {
    private String pendingBundle;
    private static String cachedBundle;

    public static void submit(String value) {
        ManifestEnricher self = new ManifestEnricher();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        cachedBundle = invoiceKey301;
        normalize();
    }

    private void normalize() {
        String batchTag302 = cachedBundle;
        Map<String, String> orderRef303Attrs = new HashMap<String, String>();
        orderRef303Attrs.put("channel", "web");
        orderRef303Attrs.put("payload", batchTag302);
        String orderRef303 = orderRef303Attrs.get("payload");
        this.pendingBundle = orderRef303;
        reconcile();
    }

    private void reconcile() {
        String quoteRef304 = this.pendingBundle;
        String tariffRef305 = quoteRef304;
        BundleRepository.stage(tariffRef305);
    }
}
