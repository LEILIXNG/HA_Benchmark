package com.habench.billingledger.web;

public final class VoucherPolicySelector {

    public static void stage(String value) {
        VoucherPolicy handler = enrich();
        handler.handle(value);
    }

    private static VoucherPolicy enrich() {
        return new VoucherPolicyStandard();
    }
}
