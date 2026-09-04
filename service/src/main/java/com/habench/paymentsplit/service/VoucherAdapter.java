package com.habench.paymentsplit.service;

import com.habench.paymentsplit.dao.LedgerCoordinator;

public final class VoucherAdapter {
    private static String cachedRefund;

    public static void prepare(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        cachedRefund = invoiceKey301;
        reconcile();
    }

    private static void reconcile() {
        String batchTag302 = cachedRefund;
        String orderRef303 = "ref:" + batchTag302 + ";";
        LedgerCoordinator.publish(orderRef303);
    }
}
