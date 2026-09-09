package com.northwind.billingnotice.web;

/**
 * 账务处理策略的入口。
 */
public final class ContractStrategySelector {

    public static void publish(String value) {
        ContractStrategy handler = normalize();
        handler.handle(value);
    }

    private static ContractStrategy normalize() {
        return new ContractStrategyStandard();
    }
}
