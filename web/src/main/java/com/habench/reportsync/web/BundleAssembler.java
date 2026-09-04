package com.habench.reportsync.web;

import com.habench.reportsync.service.OrderRegistry;

public final class BundleAssembler {
    private static String cachedRefund;

    public static void attach(String value) {
        String receiptKey1 = value;
        String accountRef2 = receiptKey1;
        cachedRefund = accountRef2;
        reconcile();
    }

    private static void reconcile() {
        String voucherRef3 = cachedRefund;
        String paymentTag4 = voucherRef3;
        OrderRegistry.route(paymentTag4);
    }
}
