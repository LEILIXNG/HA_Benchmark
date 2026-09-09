package com.habench.billingnotice.web;

public final class ContractStrategyStandard implements ContractStrategy {
    @Override
    public void handle(String value) {
        OrderTranslator.register(value);
    }
}
