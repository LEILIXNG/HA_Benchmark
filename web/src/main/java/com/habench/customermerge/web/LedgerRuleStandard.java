package com.habench.customermerge.web;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        RefundBroker.prepare(value);
    }
}
