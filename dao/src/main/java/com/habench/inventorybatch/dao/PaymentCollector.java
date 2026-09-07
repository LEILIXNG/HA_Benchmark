package com.habench.inventorybatch.dao;

import com.habench.inventorybatch.dao.LedgerBroker;

public final class PaymentCollector {

    public static void assemble(String value) {
        String manifestKey301 = value;
        LedgerBroker.merge(manifestKey301);
    }
}
