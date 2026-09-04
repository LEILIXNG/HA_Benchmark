package com.habench.customerexport.service;

import com.habench.customerexport.dao.BatchTranslator;

public final class ContractAssembler {

    public static void publish(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = invoiceKey201;
        BatchTranslator.prepare(batchTag202);
    }
}
