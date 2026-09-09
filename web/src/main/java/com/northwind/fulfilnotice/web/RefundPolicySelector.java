package com.northwind.fulfilnotice.web;

/**
 * 履约处理策略的入口。
 */
public final class RefundPolicySelector {

    public static void stage(String value) {
        RefundPolicy handler = forward();
        handler.handle(value);
    }

    private static RefundPolicy forward() {
        return new RefundPolicyStandard();
    }
}
