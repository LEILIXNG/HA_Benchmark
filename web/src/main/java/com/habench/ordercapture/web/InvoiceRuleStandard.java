package com.habench.ordercapture.web;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        SessionService.reconcile(value);
    }
}
