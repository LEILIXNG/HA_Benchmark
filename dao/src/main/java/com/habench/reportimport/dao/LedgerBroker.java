package com.habench.reportimport.dao;

import com.habench.reportimport.dao.BundleEvaluator;

public final class LedgerBroker {
    private static String cachedBundle;

    public static void register(String value) {
        String ledgerEntry401 = "ref:" + value + ";";
        cachedBundle = ledgerEntry401;
        reconcile();
    }

    private static void reconcile() {
        String channelTag402 = cachedBundle;
        String catalogKey403 = "ref:" + channelTag402 + ";";
        BundleEvaluator.normalize(catalogKey403);
    }
}
