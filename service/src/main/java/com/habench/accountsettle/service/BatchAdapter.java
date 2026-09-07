package com.habench.accountsettle.service;

import com.habench.accountsettle.service.CatalogPolicySelector;

public final class BatchAdapter {

    public static void refine(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = catalogKey201;
        CatalogPolicySelector.translate(receiptKey202);
    }
}
