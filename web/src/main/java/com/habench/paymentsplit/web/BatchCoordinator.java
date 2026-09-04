package com.habench.paymentsplit.web;

import com.habench.paymentsplit.web.CatalogPlanSelector;

public final class BatchCoordinator {

    public static void collect(String value) {
        String invoiceKey1 = value;
        CatalogPlanSelector.enrich(invoiceKey1);
    }
}
