package com.habench.billingverify.web;

import com.habench.billingverify.web.BundleBuilder;

public final class VoucherCoordinator {

    public static void prepare(String value) {
        String voucherRef1 = "ref:" + value + ";";
        BundleBuilder.translate(voucherRef1);
    }
}
