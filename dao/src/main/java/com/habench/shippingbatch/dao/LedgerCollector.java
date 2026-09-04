package com.habench.shippingbatch.dao;

import com.habench.shippingbatch.dao.CatalogExecutor;

public final class LedgerCollector {

    public static void enrich(String value) {
        String voucherRef301 = value;
        CatalogExecutor.stage(voucherRef301);
    }
}
