package com.habench.pricingtransfer.web;

public final class ReceiptRuleStandard implements ReceiptRule {
    @Override
    public void handle(String value) {
        LedgerRouter.collect(value);
    }
}
