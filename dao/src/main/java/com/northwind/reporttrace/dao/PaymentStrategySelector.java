package com.northwind.reporttrace.dao;

/**
 * 报表处理策略的入口。
 */
public final class PaymentStrategySelector {

    public static void collect(String value) {
        PaymentStrategy handler = publish();
        handler.handle(value);
    }

    private static PaymentStrategy publish() {
        return new PaymentStrategyStandard();
    }
}
