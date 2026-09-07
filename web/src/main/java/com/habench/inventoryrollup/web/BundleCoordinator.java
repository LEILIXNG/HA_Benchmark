package com.habench.inventoryrollup.web;

import com.habench.inventoryrollup.service.OrderRouter;

public final class BundleCoordinator {
    private static String cachedAccount;

    public static void assemble(String value) {
        String receiptKey1 = "ref:" + value + ";";
        String accountRef2 = receiptKey1;
        cachedAccount = accountRef2;
        compose();
    }

    private static void compose() {
        String voucherRef3 = cachedAccount;
        String paymentTag4 = "ref:" + voucherRef3 + ";";
        String refundCode5 = "ref:" + paymentTag4 + ";";
        OrderRouter.merge(refundCode5);
    }
}
