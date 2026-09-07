package com.habench.paymentgrant.dao;

import com.habench.paymentgrant.dao.BundleExecutor;

public final class VoucherBroker {
    private static String cachedBundle;

    public static void forward(String value) {
        cachedBundle = value;
        prepare();
    }

    private static void prepare() {
        String quoteRef301 = cachedBundle;
        BundleExecutor.expand(quoteRef301);
    }
}
