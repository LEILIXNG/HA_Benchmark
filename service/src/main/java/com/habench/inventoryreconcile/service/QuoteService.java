package com.habench.inventoryreconcile.service;

import com.habench.inventoryreconcile.service.VoucherPlanSelector;

public final class QuoteService {
    private static String cachedManifest;

    public static void enrich(String value) {
        String manifestKey101 = "ref:" + value + ";";
        cachedManifest = manifestKey101;
        merge();
    }

    private static void merge() {
        String invoiceKey102 = cachedManifest;
        String batchTag103 = "ref:" + invoiceKey102 + ";";
        String orderRef104 = "ref:" + batchTag103 + ";";
        VoucherPlanSelector.dispatch(orderRef104);
    }
}
