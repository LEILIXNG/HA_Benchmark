package com.habench.catalogdraft.service;

public final class ReceiptPolicySelector {

    public static void prepare(String value) {
        ReceiptPolicy handler = dispatch();
        handler.handle(value);
    }

    private static ReceiptPolicy dispatch() {
        return new ReceiptPolicyStandard();
    }
}
