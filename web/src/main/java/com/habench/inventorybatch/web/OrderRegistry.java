package com.habench.inventorybatch.web;

import com.habench.inventorybatch.web.CatalogStrategySelector;

public final class OrderRegistry {

    public static void forward(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = catalogKey1;
        CatalogStrategySelector.refine(receiptKey2);
    }
}
