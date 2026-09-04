package com.habench.reportbind.web;

import com.habench.reportbind.service.ContractEnricher;

public final class PaymentCollector {

    public static void enrich(String value) {
        String invoiceKey201 = value;
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        ContractEnricher.assemble(batchTag202);
    }
}
