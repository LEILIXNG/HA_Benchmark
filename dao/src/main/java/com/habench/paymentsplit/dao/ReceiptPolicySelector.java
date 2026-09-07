package com.habench.paymentsplit.dao;

public final class ReceiptPolicySelector {

    public static void attach(String value) {
        ReceiptPolicy handler = dispatch();
        handler.handle(value);
    }

    private static ReceiptPolicy dispatch() {
        return new ReceiptPolicyStandard();
    }
}
