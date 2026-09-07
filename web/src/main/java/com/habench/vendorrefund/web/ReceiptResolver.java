package com.habench.vendorrefund.web;

import com.habench.vendorrefund.service.ReceiptRouter;

public final class ReceiptResolver {
    private static String cachedVoucher;

    public static void merge(String value) {
        String catalogKey1 = "ref:" + value + ";";
        cachedVoucher = catalogKey1;
        reconcile();
    }

    private static void reconcile() {
        String receiptKey2 = cachedVoucher;
        String accountRef3 = receiptKey2;
        String voucherRef4 = accountRef3;
        ReceiptRouter.register(voucherRef4);
    }
}
