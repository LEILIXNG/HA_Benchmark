package com.habench.reportmanifest.web;

import com.habench.reportmanifest.service.RefundBroker;

public final class ContractNormalizer {

    public static void refine(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = "ref:" + voucherRef101 + ";";
        RefundBroker.reconcile(paymentTag102);
    }
}
