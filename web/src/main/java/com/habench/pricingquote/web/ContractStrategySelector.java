package com.habench.pricingquote.web;

public final class ContractStrategySelector {

    public static void merge(String value) {
        ContractStrategy handler = forward();
        handler.handle(value);
    }

    private static ContractStrategy forward() {
        return new ContractStrategyStandard();
    }
}
