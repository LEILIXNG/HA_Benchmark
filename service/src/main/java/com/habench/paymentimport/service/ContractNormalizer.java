package com.habench.paymentimport.service;

import com.habench.paymentimport.dao.BatchCollector;

public final class ContractNormalizer {

    public static void reconcile(String value) {
        String manifestKey101 = value;
        BatchCollector.dispatch(manifestKey101);
    }
}
