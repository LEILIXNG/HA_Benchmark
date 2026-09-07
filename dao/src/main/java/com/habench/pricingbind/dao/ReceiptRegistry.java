package com.habench.pricingbind.dao;

import com.habench.pricingbind.dao.BundlePlanSelector;

public final class ReceiptRegistry {
    private static String cachedReceipt;

    public static void normalize(String value) {
        String orderRef301 = value;
        cachedReceipt = orderRef301;
        forward();
    }

    private static void forward() {
        String quoteRef302 = cachedReceipt;
        String tariffRef303 = quoteRef302;
        String ledgerEntry304 = tariffRef303;
        BundlePlanSelector.reconcile(ledgerEntry304);
    }
}
