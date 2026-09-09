package com.habench.orderarchive.service;

public final class ContractStrategySelector {

    public static void expand(String value) {
        ContractStrategy handler = enrich();
        handler.handle(value);
    }

    private static ContractStrategy enrich() {
        return new ContractStrategyStandard();
    }
}
