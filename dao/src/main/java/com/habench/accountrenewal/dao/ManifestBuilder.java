package com.habench.accountrenewal.dao;

import com.habench.accountrenewal.dao.VoucherStrategySelector;

public final class ManifestBuilder {
    private static String cachedContract;

    public static void assemble(String value) {
        String quoteRef301 = value;
        String tariffRef302 = quoteRef301;
        cachedContract = tariffRef302;
        reconcile();
    }

    private static void reconcile() {
        String ledgerEntry303 = cachedContract;
        String channelTag304 = "ref:" + ledgerEntry303 + ";";
        String catalogKey305 = "ref:" + channelTag304 + ";";
        VoucherStrategySelector.assemble(catalogKey305);
    }
}
