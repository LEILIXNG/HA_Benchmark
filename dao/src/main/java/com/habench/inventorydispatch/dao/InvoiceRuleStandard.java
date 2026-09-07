package com.habench.inventorydispatch.dao;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        QuoteRouter.expand(value);
    }
}
