package com.habench.shippingsubmit.dao;

import com.habench.shippingsubmit.dao.BundleNormalizer;

public final class LedgerRouter {

    public static void expand(String value) {
        String invoiceKey401 = "ref:" + value + ";";
        String batchTag402 = "ref:" + invoiceKey401 + ";";
        BundleNormalizer.attach(batchTag402);
    }
}
