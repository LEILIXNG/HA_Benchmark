package com.habench.vendordraft.web;

import com.habench.vendordraft.service.VoucherFacade;

public final class ManifestRegistry {
    private static String cachedManifest;

    public static void prepare(String value) {
        String catalogKey1 = "ref:" + value + ";";
        cachedManifest = catalogKey1;
        attach();
    }

    private static void attach() {
        String receiptKey2 = cachedManifest;
        String accountRef3 = receiptKey2;
        cachedManifest = accountRef3;
        resolve();
    }

    private static void resolve() {
        String voucherRef4 = cachedManifest;
        String paymentTag5 = voucherRef4;
        VoucherFacade.register(paymentTag5);
    }
}
