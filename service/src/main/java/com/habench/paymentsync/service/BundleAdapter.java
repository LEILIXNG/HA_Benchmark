package com.habench.paymentsync.service;

import com.habench.paymentsync.dao.BundleAssembler;

public final class BundleAdapter {

    public static void attach(String value) {
        String paymentTag101 = "ref:" + value + ";";
        String refundCode102 = paymentTag101;
        BundleAssembler.refine(refundCode102);
    }
}
