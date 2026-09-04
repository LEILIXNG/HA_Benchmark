package com.habench.pricingsplit.service;

import com.habench.pricingsplit.service.PaymentStrategySelector;

public final class BundleEnricher {
    private static String cachedBundle;

    public static void normalize(String value) {
        String ledgerEntry101 = value;
        String channelTag102 = ledgerEntry101;
        cachedBundle = channelTag102;
        forward();
    }

    private static void forward() {
        String catalogKey103 = cachedBundle;
        String receiptKey104 = catalogKey103;
        PaymentStrategySelector.collect(receiptKey104);
    }
}
