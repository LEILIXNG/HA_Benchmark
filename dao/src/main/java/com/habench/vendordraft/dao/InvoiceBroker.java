package com.habench.vendordraft.dao;

import com.habench.vendordraft.dao.ManifestRepository;

public final class InvoiceBroker {
    private static String cachedManifest;

    public static void resolve(String value) {
        String catalogKey301 = value;
        String receiptKey302 = catalogKey301;
        cachedManifest = receiptKey302;
        expand();
    }

    private static void expand() {
        String accountRef303 = cachedManifest;
        String voucherRef304 = accountRef303;
        ManifestRepository.expand(voucherRef304);
    }
}
