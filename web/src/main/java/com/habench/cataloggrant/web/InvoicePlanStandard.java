package com.habench.cataloggrant.web;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        RefundResolver.enrich(value);
    }
}
