package com.habench.billinglookup.dao;

public final class VoucherPolicySelector {

    public static void normalize(String value) {
        VoucherPolicy handler = publish();
        handler.handle(value);
    }

    private static VoucherPolicy publish() {
        return new VoucherPolicyStandard();
    }
}
