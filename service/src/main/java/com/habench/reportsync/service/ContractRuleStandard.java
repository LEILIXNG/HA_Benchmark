package com.habench.reportsync.service;

public final class ContractRuleStandard implements ContractRule {
    @Override
    public void handle(String value) {
        ReceiptService.compose(value);
    }
}
