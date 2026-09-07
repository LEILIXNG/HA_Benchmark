package com.habench.orderimport.service;

import com.habench.orderimport.service.ContractEvaluator;

public final class InvoiceCollector {

    public static void collect(String value) {
        String voucherRef201 = "ref:" + value + ";";
        ContractEvaluator.assemble(voucherRef201);
    }
}
