package com.habench.catalogissue.web;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        RefundCoordinator.attach(value);
    }
}
