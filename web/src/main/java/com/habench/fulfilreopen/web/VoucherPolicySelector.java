package com.habench.fulfilreopen.web;

public final class VoucherPolicySelector {

    public static void merge(String value) {
        VoucherPolicy handler = route();
        handler.handle(value);
    }

    private static VoucherPolicy route() {
        return new VoucherPolicyStandard();
    }
}
