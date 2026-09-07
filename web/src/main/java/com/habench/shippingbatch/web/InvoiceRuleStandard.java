package com.habench.shippingbatch.web;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        LedgerCollector.enrich(value);
    }
}
