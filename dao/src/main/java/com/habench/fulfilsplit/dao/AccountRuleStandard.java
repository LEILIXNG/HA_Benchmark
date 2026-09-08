package com.habench.fulfilsplit.dao;

public final class AccountRuleStandard implements AccountRule {
    @Override
    public void handle(String value) {
        BatchCoordinator.register(value);
    }
}
