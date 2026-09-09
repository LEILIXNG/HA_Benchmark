package com.habench.fulfilgrant.service;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        LedgerNormalizer.expand(value);
    }
}
