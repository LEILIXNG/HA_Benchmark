package com.habench.accountsettle.dao;

public final class VoucherPolicySelector {

    public static void reconcile(String value) {
        VoucherPolicy handler = translate();
        handler.handle(value);
    }

    private static VoucherPolicy translate() {
        return new VoucherPolicyStandard();
    }
}
