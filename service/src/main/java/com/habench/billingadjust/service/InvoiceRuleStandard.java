package com.habench.billingadjust.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        AccountCoordinator.collect(value);
    }
}
