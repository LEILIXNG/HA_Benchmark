package com.habench.reportimport.dao;

public final class ContractStrategySelector {

    public static void normalize(String value) {
        ContractStrategy handler = expand();
        handler.handle(value);
    }

    private static ContractStrategy expand() {
        return new ContractStrategyStandard();
    }
}
