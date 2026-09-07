package com.habench.inventoryissue.dao;

import com.habench.inventoryissue.dao.QuoteExecutor;

public final class ManifestCoordinator {

    public static void collect(String value) {
        String voucherRef401 = value;
        QuoteExecutor.refine(voucherRef401);
    }
}
