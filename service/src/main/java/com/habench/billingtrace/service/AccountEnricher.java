package com.habench.billingtrace.service;

import com.habench.billingtrace.dao.ManifestNormalizer;

public final class AccountEnricher {
    private static String cachedBundle;

    public static void attach(String value) {
        String invoiceKey101 = value;
        cachedBundle = invoiceKey101;
        route();
    }

    private static void route() {
        String batchTag102 = cachedBundle;
        String orderRef103 = "ref:" + batchTag102 + ";";
        String quoteRef104 = "ref:" + orderRef103 + ";";
        ManifestNormalizer.prepare(quoteRef104);
    }
}
