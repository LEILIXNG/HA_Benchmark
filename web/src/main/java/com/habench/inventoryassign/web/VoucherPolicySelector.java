package com.habench.inventoryassign.web;

public final class VoucherPolicySelector {

    public static void forward(String value) {
        VoucherPolicy handler = compose();
        handler.handle(value);
    }

    private static VoucherPolicy compose() {
        return new VoucherPolicyStandard();
    }
}
