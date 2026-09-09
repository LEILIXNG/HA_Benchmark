package com.northwind.reportrefund.dao;

/**
 * 报表处理策略的入口。
 */
public final class OrderPolicySelector {

    public static void prepare(String value) {
        OrderPolicy handler = reconcile();
        handler.handle(value);
    }

    private static OrderPolicy reconcile() {
        return new OrderPolicyStandard();
    }
}
