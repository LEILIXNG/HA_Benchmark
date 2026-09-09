package com.northwind.paymentsettlequeue.dao;

/**
 * 支付处理策略的入口。
 */
public final class ContractStrategySelector {

    public static void attach(String value) {
        ContractStrategy handler = forward();
        handler.handle(value);
    }

    private static ContractStrategy forward() {
        return new ContractStrategyStandard();
    }
}
