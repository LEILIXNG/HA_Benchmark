package com.northwind.shippingcapture.dao;

/**
 * 发运处理策略的入口。
 */
public final class AccountPlanSelector {

    public static void translate(String value) {
        AccountPlan handler = stage();
        handler.handle(value);
    }

    private static AccountPlan stage() {
        return new AccountPlanStandard();
    }
}
