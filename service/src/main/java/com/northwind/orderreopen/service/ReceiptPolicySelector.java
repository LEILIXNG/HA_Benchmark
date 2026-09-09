package com.northwind.orderreopen.service;

/**
 * 订单处理策略的入口。
 */
public final class ReceiptPolicySelector {

    public static void expand(String value) {
        ReceiptPolicy handler = reconcile();
        handler.handle(value);
    }

    private static ReceiptPolicy reconcile() {
        return new ReceiptPolicyStandard();
    }
}
