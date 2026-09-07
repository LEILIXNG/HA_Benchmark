package com.habench.paymenttransfer.web;

import com.habench.paymenttransfer.web.ContractEvaluator;

public final class TariffService {

    public static void submit(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        String batchTag202 = invoiceKey201;
        ContractEvaluator.attach(batchTag202);
    }
}
