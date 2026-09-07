package com.habench.fulfilrelease.web;

import com.habench.fulfilrelease.web.VoucherEvaluator;

public final class ContractBroker {
    private static String cachedVoucher;

    public static void stage(String value) {
        String refundCode101 = value;
        String shipmentCode102 = refundCode101;
        cachedVoucher = shipmentCode102;
        reconcile();
    }

    private static void reconcile() {
        String manifestKey103 = cachedVoucher;
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        VoucherEvaluator.enrich(invoiceKey104);
    }
}
