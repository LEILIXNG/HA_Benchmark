package com.habench.orderclose.service;

import com.habench.orderclose.service.CatalogFetcher;

public final class LedgerService {
    private static String cachedCatalog;

    public static void assemble(String value) {
        String voucherRef301 = value;
        cachedCatalog = voucherRef301;
        resolve();
    }

    private static void resolve() {
        String paymentTag302 = cachedCatalog;
        String refundCode303 = "ref:" + paymentTag302 + ";";
        CatalogFetcher.collect(refundCode303);
    }
}
