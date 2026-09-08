package com.habench.billingrollup.web;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        SessionNormalizer.stage(value);
    }
}
