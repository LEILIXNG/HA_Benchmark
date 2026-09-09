package com.habench.billingnotice.web;

public final class ContractStrategySelector {

    public static void publish(String value) {
        ContractStrategy handler = normalize();
        handler.handle(value);
    }

    private static ContractStrategy normalize() {
        return new ContractStrategyStandard();
    }
}
