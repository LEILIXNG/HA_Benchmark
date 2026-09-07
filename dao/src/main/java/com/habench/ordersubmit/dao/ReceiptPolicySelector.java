package com.habench.ordersubmit.dao;

public final class ReceiptPolicySelector {

    public static void register(String value) {
        ReceiptPolicy handler = submit();
        handler.handle(value);
    }

    private static ReceiptPolicy submit() {
        return new ReceiptPolicyStandard();
    }
}
