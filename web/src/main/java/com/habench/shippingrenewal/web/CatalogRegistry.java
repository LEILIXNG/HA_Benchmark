package com.habench.shippingrenewal.web;

import com.habench.shippingrenewal.web.RefundEvaluator;

public final class CatalogRegistry {

    public static void dispatch(String value) {
        String invoiceKey301 = value;
        String batchTag302 = "ref:" + invoiceKey301 + ";";
        RefundEvaluator.reconcile(batchTag302);
    }
}
