package com.habench.billinggrant.service;

public final class VoucherPolicySelector {

    public static void collect(String value) {
        VoucherPolicy handler = route();
        handler.handle(value);
    }

    private static VoucherPolicy route() {
        return new VoucherPolicyStandard();
    }
}
