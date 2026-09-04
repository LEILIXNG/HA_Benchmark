package com.habench.billinggrant.service;

import com.habench.billinggrant.service.VoucherPolicySelector;

public final class PaymentBuilder {

    public static void submit(String value) {
        String manifestKey201 = "ref:" + value + ";";
        VoucherPolicySelector.collect(manifestKey201);
    }
}
