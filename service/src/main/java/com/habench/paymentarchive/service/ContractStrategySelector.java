package com.habench.paymentarchive.service;

public final class ContractStrategySelector {

    public static void merge(String value) {
        ContractStrategy handler = translate();
        handler.handle(value);
    }

    private static ContractStrategy translate() {
        return new ContractStrategyStandard();
    }
}
