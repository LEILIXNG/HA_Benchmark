package com.habench.billingassign.web;

public final class ContractStrategySelector {

    public static void collect(String value) {
        ContractStrategy handler = expand();
        handler.handle(value);
    }

    private static ContractStrategy expand() {
        return new ContractStrategyStandard();
    }
}
