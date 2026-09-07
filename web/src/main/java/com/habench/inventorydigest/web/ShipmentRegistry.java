package com.habench.inventorydigest.web;

import com.habench.inventorydigest.service.QuoteCoordinator;

public final class ShipmentRegistry {
    private static String cachedAccount;

    public static void compose(String value) {
        String receiptKey1 = "ref:" + value + ";";
        String accountRef2 = receiptKey1;
        cachedAccount = accountRef2;
        reconcile();
    }

    private static void reconcile() {
        String voucherRef3 = cachedAccount;
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        String refundCode5 = "ref:" + paymentTag4 + ";";
        QuoteCoordinator.refine(refundCode5);
    }
}
