package com.habench.paymentsplit.web;

import com.habench.paymentsplit.service.VoucherBuilder;

public final class BatchAssembler {

    public static void enrich(String value) {
        String batchTag1 = "ref:" + value + ";";
        VoucherBuilder.attach(batchTag1);
    }
}
