package com.northwind.vendorverify.web;

/**
 * 供应商处理策略的入口。
 */
public final class RefundPolicySelector {

    public static void reconcile(String value) {
        RefundPolicy handler = refine();
        handler.handle(value);
    }

    private static RefundPolicy refine() {
        return new RefundPolicyStandard();
    }
}
