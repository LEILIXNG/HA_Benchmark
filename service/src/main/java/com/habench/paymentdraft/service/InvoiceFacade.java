package com.habench.paymentdraft.service;

import com.habench.paymentdraft.service.ManifestEnricher;

public final class InvoiceFacade {
    private static String cachedBatch;

    public static void enrich(String value) {
        String invoiceKey101 = value;
        String batchTag102 = "ref:" + invoiceKey101 + ";";
        cachedBatch = batchTag102;
        normalize();
    }

    private static void normalize() {
        String orderRef103 = cachedBatch;
        String quoteRef104 = "ref:" + orderRef103 + ";";
        String tariffRef105 = quoteRef104;
        ManifestEnricher.merge(tariffRef105);
    }
}
