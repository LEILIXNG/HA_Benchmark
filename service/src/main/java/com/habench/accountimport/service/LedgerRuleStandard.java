package com.habench.accountimport.service;

public final class LedgerRuleStandard implements LedgerRule {
    @Override
    public void handle(String value) {
        VoucherTranslator.register(value);
    }
}
