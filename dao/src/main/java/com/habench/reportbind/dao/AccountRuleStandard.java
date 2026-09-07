package com.habench.reportbind.dao;

public final class AccountRuleStandard implements AccountRule {
    @Override
    public void handle(String value) {
        BatchService.route(value);
    }
}
