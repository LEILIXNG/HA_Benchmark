package com.habench.shippingbatch.web;

import com.habench.shippingbatch.web.CatalogExecutor;

public final class LedgerCollector {

    public static void enrich(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = catalogKey201;
        CatalogExecutor.stage(receiptKey202);
    }
}
