package com.habench.paymentledger.dao;

import com.habench.paymentledger.dao.BundleFilter;

public final class LedgerFacade {

    public static void merge(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        BundleFilter.route(invoiceKey301);
    }
}
