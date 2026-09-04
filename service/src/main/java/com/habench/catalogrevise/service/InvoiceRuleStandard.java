package com.habench.catalogrevise.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        QuoteResolver.publish(value);
    }
}
