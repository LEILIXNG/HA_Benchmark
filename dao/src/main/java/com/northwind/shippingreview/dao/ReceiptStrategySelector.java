package com.northwind.shippingreview.dao;

/**
 * 发运处理策略的入口。
 */
public final class ReceiptStrategySelector {

    public static void compose(String value) {
        ReceiptStrategy handler = collect();
        handler.handle(value);
    }

    private static ReceiptStrategy collect() {
        return new ReceiptStrategyStandard();
    }
}
