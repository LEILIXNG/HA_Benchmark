package com.habench.accountreopen.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        SessionNormalizer.submit(value);
    }
}
