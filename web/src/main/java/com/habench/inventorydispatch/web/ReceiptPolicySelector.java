package com.habench.inventorydispatch.web;

public final class ReceiptPolicySelector {

    public static void dispatch(String value) {
        ReceiptPolicy handler = merge();
        handler.handle(value);
    }

    private static ReceiptPolicy merge() {
        return new ReceiptPolicyStandard();
    }
}
