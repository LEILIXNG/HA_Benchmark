package com.habench.accountsplit.web;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        BatchService.register(value);
    }
}
