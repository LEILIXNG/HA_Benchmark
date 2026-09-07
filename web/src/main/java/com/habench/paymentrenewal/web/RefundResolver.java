package com.habench.paymentrenewal.web;

import com.habench.paymentrenewal.web.TariffTranslator;

public final class RefundResolver {
    private static String cachedManifest;

    public static void refine(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        cachedManifest = receiptKey2;
        normalize();
    }

    private static void normalize() {
        String accountRef3 = cachedManifest;
        String voucherRef4 = "ref:" + accountRef3 + ";";
        TariffTranslator.enrich(voucherRef4);
    }
}
