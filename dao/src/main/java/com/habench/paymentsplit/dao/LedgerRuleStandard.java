package com.habench.paymentsplit.dao;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        AccountService.stage(value);
    }
}
