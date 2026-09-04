package com.habench.billingquote.dao;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        ContractBuilder.translate(value);
    }
}
