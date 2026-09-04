package com.habench.inventoryassign.service;

public final class VoucherPolicySelector {

    public static void forward(String value) {
        VoucherPolicy handler = compose();
        handler.handle(value);
    }

    private static VoucherPolicy compose() {
        return new VoucherPolicyStandard();
    }
}
