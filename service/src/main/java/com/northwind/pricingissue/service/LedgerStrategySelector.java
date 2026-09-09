package com.northwind.pricingissue.service;

/**
 * 定价处理策略的入口。
 */
public final class LedgerStrategySelector {

    public static void attach(String value) {
        LedgerStrategy handler = register();
        handler.handle(value);
    }

    private static LedgerStrategy register() {
        return new LedgerStrategyStandard();
    }
}
