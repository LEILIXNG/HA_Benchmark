package com.habench.paymentrelease.web;

import com.habench.paymentrelease.web.AccountPolicySelector;

public final class VoucherRegistry {

    public static void expand(String value) {
        String refundCode101 = value;
        AccountPolicySelector.prepare(refundCode101);
    }
}
