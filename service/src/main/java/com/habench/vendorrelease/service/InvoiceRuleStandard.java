package com.habench.vendorrelease.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        ReceiptNormalizer.translate(value);
    }
}
