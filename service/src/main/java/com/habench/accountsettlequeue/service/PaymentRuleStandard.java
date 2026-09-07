package com.habench.accountsettlequeue.service;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        ContractEnricher.enrich(value);
    }
}
