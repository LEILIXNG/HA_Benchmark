package com.habench.billingadjust.web;

public final class InvoicePlanStandard implements InvoicePlan {
    @Override
    public void handle(String value) {
        AccountNormalizer.prepare(value);
    }
}
