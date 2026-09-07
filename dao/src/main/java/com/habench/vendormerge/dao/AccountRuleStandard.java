package com.habench.vendormerge.dao;

public final class AccountRuleStandard implements AccountRule {
    @Override
    public void handle(String value) {
        BatchCoordinator.register(value);
    }
}
