package com.habench.shippingreconcile.dao;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        QuoteRouter.expand(value);
    }
}
