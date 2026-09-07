package com.habench.reportcapture.service;

public final class InvoiceRuleStandard implements InvoiceRule {
    @Override
    public void handle(String value) {
        RefundComposer.expand(value);
    }
}
