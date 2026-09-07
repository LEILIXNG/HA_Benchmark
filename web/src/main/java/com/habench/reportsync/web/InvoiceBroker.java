package com.habench.reportsync.web;

import com.habench.reportsync.service.CatalogAdapter;

public final class InvoiceBroker {

    public static void publish(String value) {
        String batchTag1 = "ref:" + value + ";";
        CatalogAdapter.expand(batchTag1);
    }
}
