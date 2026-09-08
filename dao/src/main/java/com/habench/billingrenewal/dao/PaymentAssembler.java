package com.habench.billingrenewal.dao;

import com.habench.billingrenewal.dao.ShipmentNormalizer;

public final class PaymentAssembler {
    private static String cachedInvoice;

    public static void collect(String value) {
        cachedInvoice = value;
        reconcile();
    }

    private static void reconcile() {
        String accountRef401 = cachedInvoice;
        ShipmentNormalizer.merge(accountRef401);
    }
}
