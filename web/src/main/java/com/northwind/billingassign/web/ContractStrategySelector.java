package com.northwind.billingassign.web;

/**
 * 账务处理策略的入口。
 */
public final class ContractStrategySelector {

    public static void collect(String value) {
        ContractStrategy handler = expand();
        handler.handle(value);
    }

    private static ContractStrategy expand() {
        return new ContractStrategyStandard();
    }
}
