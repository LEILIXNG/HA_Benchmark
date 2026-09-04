package com.habench.paymentsplit.web;

public final class CatalogPlanStandard implements CatalogPlan {
    @Override
    public void handle(String value) {
        LedgerTranslator.dispatch(value);
    }
}
