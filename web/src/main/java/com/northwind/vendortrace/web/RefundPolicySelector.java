package com.northwind.vendortrace.web;

/**
 * 供应商处理策略的入口。
 */
public final class RefundPolicySelector {

    public static void reconcile(String value) {
        RefundPolicy handler = assemble();
        handler.handle(value);
    }

    private static RefundPolicy assemble() {
        return new RefundPolicyStandard();
    }
}
