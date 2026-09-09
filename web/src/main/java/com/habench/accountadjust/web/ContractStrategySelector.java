package com.habench.accountadjust.web;

public final class ContractStrategySelector {

    public static void route(String value) {
        ContractStrategy handler = dispatch();
        handler.handle(value);
    }

    private static ContractStrategy dispatch() {
        return new ContractStrategyStandard();
    }
}
