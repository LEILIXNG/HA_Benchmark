package com.habench.paymentarchive.service;

import com.habench.paymentarchive.dao.InvoiceAssembler;

public final class BundleResolver {

    public static void normalize(String value) {
        String voucherRef101 = "ref:" + value + ";";
        InvoiceAssembler.register(voucherRef101);
    }
}
