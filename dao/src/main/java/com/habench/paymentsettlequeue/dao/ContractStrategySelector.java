package com.habench.paymentsettlequeue.dao;

public final class ContractStrategySelector {

    public static void attach(String value) {
        ContractStrategy handler = forward();
        handler.handle(value);
    }

    private static ContractStrategy forward() {
        return new ContractStrategyStandard();
    }
}
