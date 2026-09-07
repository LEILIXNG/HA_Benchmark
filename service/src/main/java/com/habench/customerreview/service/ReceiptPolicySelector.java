package com.habench.customerreview.service;

public final class ReceiptPolicySelector {

    public static void route(String value) {
        ReceiptPolicy handler = prepare();
        handler.handle(value);
    }

    private static ReceiptPolicy prepare() {
        return new ReceiptPolicyStandard();
    }
}
