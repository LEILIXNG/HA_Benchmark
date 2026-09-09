package com.northwind.inventoryassign.web;

/**
 * 库存处理策略的入口。
 */
public final class AccountPlanSelector {

    public static void normalize(String value) {
        AccountPlan handler = resolve();
        handler.handle(value);
    }

    private static AccountPlan resolve() {
        return new AccountPlanStandard();
    }
}
