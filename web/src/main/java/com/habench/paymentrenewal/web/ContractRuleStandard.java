package com.habench.paymentrenewal.web;

public final class ContractRuleStandard implements ContractRule {
    @Override
    public void handle(String value) {
        BatchEnricher.stage(value);
    }
}
