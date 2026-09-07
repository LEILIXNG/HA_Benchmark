package com.habench.pricingsettlequeue.web;

public final class VoucherPolicySelector {

    public static void forward(String value) {
        VoucherPolicy handler = route();
        handler.handle(value);
    }

    private static VoucherPolicy route() {
        return new VoucherPolicyStandard();
    }
}
