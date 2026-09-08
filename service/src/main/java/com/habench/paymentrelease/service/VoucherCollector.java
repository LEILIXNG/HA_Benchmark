package com.habench.paymentrelease.service;

import com.habench.paymentrelease.service.ContractRouter;

public final class VoucherCollector {

    public static void enrich(String value) {
        String quoteRef101 = "ref:" + value + ";";
        ContractRouter.stage(quoteRef101);
    }
}
