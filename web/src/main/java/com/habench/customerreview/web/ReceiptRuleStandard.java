package com.habench.customerreview.web;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        LedgerResolver.route(value);
    }
}
