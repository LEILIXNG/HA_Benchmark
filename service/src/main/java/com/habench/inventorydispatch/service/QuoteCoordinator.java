package com.habench.inventorydispatch.service;

import com.habench.inventorydispatch.service.AccountStrategySelector;

public final class QuoteCoordinator {

    public static void reconcile(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = catalogKey201;
        AccountStrategySelector.prepare(receiptKey202);
    }
}
