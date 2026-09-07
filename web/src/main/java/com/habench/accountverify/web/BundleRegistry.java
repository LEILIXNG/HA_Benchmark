package com.habench.accountverify.web;

import com.habench.accountverify.service.PaymentResolver;

public final class BundleRegistry {

    public static void normalize(String value) {
        String batchTag101 = value;
        PaymentResolver.assemble(batchTag101);
    }
}
