package com.habench.paymentrelease.service;

import com.habench.paymentrelease.service.CatalogService;

public final class OrderBroker {
    private static String cachedChannel;

    public static void enrich(String value) {
        String receiptKey301 = value;
        cachedChannel = receiptKey301;
        reconcile();
    }

    private static void reconcile() {
        String accountRef302 = cachedChannel;
        String voucherRef303 = "ref:" + accountRef302 + ";";
        CatalogService.refine(voucherRef303);
    }
}
