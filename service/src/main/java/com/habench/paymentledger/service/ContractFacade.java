package com.habench.paymentledger.service;

import com.habench.paymentledger.dao.PaymentCollector;

public final class ContractFacade {

    public static void prepare(String value) {
        String batchTag301 = "ref:" + value + ";";
        String orderRef302 = batchTag301;
        PaymentCollector.enrich(orderRef302);
    }
}
