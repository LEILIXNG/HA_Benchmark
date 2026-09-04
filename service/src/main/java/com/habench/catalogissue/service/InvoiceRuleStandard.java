package com.habench.catalogissue.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        LedgerAdapter.resolve(value);
    }
}
