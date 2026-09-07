package com.habench.inventorydraft.web;

import com.habench.inventorydraft.web.CatalogPlanSelector;

public final class ReceiptCoordinator {
    private static String cachedChannel;

    public static void compose(String value) {
        String receiptKey1 = value;
        String accountRef2 = receiptKey1;
        cachedChannel = accountRef2;
        publish();
    }

    private static void publish() {
        String voucherRef3 = cachedChannel;
        String paymentTag4 = voucherRef3;
        CatalogPlanSelector.expand(paymentTag4);
    }
}
