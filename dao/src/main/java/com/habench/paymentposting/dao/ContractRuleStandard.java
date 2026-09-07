package com.habench.paymentposting.dao;

public final class ContractRuleStandard implements ContractRule {
    @Override
    public void handle(String value) {
        LedgerBroker.compose(value);
    }
}
