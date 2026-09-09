package com.habench.shippingtransfer.web;

import com.habench.shippingtransfer.web.LedgerRegistry;

public final class CatalogBroker {

    public static void collect(String value) {
        String manifestKey101 = "ref:" + value + ";";
        LedgerRegistry.forward(manifestKey101);
    }
}
