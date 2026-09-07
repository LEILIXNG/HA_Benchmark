package com.habench.customerdigest.web;

public final class LedgerPlanStandard implements LedgerPlan {
    @Override
    public void handle(String value) {
        InvoiceResolver.normalize(value);
    }
}
