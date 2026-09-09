package com.habench.catalogcapture.dao;

import com.habench.catalogcapture.dao.LedgerBroker;

public final class PaymentCollector {

    public static void assemble(String value) {
        String manifestKey301 = value;
        LedgerBroker.merge(manifestKey301);
    }
}
