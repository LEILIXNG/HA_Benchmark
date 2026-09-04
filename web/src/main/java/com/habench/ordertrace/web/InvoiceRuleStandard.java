package com.habench.ordertrace.web;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        BatchCoordinator.submit(value);
    }
}
