package com.habench.cataloggrant.web;

import com.habench.cataloggrant.service.VoucherComposer;

public final class RefundResolver {
    private static String cachedManifest;

    public static void enrich(String value) {
        String manifestKey101 = "ref:" + value + ";";
        cachedManifest = manifestKey101;
        resolve();
    }

    private static void resolve() {
        String invoiceKey102 = cachedManifest;
        String batchTag103 = "ref:" + invoiceKey102 + ";";
        cachedManifest = batchTag103;
        merge();
    }

    private static void merge() {
        String orderRef104 = cachedManifest;
        String quoteRef105 = orderRef104;
        VoucherComposer.merge(quoteRef105);
    }
}
