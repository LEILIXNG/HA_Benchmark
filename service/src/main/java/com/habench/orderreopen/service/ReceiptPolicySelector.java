package com.habench.orderreopen.service;

public final class ReceiptPolicySelector {

    public static void expand(String value) {
        ReceiptPolicy handler = reconcile();
        handler.handle(value);
    }

    private static ReceiptPolicy reconcile() {
        return new ReceiptPolicyStandard();
    }
}
