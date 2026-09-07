package com.habench.vendorsplit.dao;

import com.habench.vendorsplit.dao.QuotePolicySelector;

public final class LedgerBuilder {
    private static String cachedPayment;

    public static void reconcile(String value) {
        String ledgerEntry401 = value;
        cachedPayment = ledgerEntry401;
        normalize();
    }

    private static void normalize() {
        String channelTag402 = cachedPayment;
        String catalogKey403 = "ref:" + channelTag402 + ";";
        String receiptKey404 = catalogKey403;
        QuotePolicySelector.prepare(receiptKey404);
    }
}
