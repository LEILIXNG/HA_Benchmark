package com.habench.ordersettle.service;

public final class BatchRuleStandard implements BatchRule {
    @Override
    public void handle(String value) {
        PaymentFacade.attach(value);
    }
}
