package com.habench.reportsplit.web;

import com.habench.reportsplit.web.LedgerRegistry;

public final class CatalogBroker {

    public static void collect(String value) {
        String manifestKey101 = "ref:" + value + ";";
        LedgerRegistry.forward(manifestKey101);
    }
}
