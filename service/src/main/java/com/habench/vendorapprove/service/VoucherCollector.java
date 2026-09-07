package com.habench.vendorapprove.service;

import com.habench.vendorapprove.service.ContractRouter;

public final class VoucherCollector {

    public static void enrich(String value) {
        String quoteRef101 = "ref:" + value + ";";
        ContractRouter.stage(quoteRef101);
    }
}
