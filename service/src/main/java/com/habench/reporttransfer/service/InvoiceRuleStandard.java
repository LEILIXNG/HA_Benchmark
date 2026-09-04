package com.habench.reporttransfer.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        SessionRouter.prepare(value);
    }
}
