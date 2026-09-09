package com.habench.inventorybatch.dao;

import com.habench.inventorybatch.dao.BatchPlanSelector;

public final class ReceiptEnricher {

    public static void forward(String value) {
        String catalogKey301 = "ref:" + value + ";";
        String receiptKey302 = "ref:" + catalogKey301 + ";";
        BatchPlanSelector.refine(receiptKey302);
    }
}
