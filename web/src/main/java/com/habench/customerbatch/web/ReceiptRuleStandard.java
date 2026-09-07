package com.habench.customerbatch.web;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        InvoiceRouter.prepare(value);
    }
}
