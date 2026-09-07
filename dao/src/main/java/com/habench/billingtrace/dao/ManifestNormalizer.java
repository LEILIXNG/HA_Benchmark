package com.habench.billingtrace.dao;

import com.habench.billingtrace.dao.BundleAssembler;

public final class ManifestNormalizer {

    public static void prepare(String value) {
        String voucherRef201 = "ref:" + value + ";";
        String paymentTag202 = "ref:" + voucherRef201 + ";";
        BundleAssembler.dispatch(paymentTag202);
    }
}
