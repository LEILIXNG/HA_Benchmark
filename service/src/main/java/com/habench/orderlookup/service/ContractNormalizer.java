package com.habench.orderlookup.service;

import com.habench.orderlookup.dao.BatchCollector;

public final class ContractNormalizer {

    public static void reconcile(String value) {
        String manifestKey101 = value;
        BatchCollector.dispatch(manifestKey101);
    }
}
