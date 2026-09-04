package com.habench.inventoryintake.web;

public final class RefundPolicySelector {

    public static void resolve(String value) {
        RefundPolicy handler = assemble();
        handler.handle(value);
    }

    private static RefundPolicy assemble() {
        return new RefundPolicyStandard();
    }
}
