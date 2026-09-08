package com.habench.paymentreopen.dao;

import com.habench.paymentreopen.dao.VoucherGateway;

public final class BundleBuilder {

    public static void reconcile(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        VoucherGateway.refine(ledgerEntry201);
    }
}
