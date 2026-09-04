package com.habench.catalogmerge.service;

public final class AccountRuleStandard implements AccountRule {
    @Override
    public void handle(String value) {
        RefundFacade.collect(value);
    }
}
