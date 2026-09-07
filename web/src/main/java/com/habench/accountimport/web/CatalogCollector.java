package com.habench.accountimport.web;

import com.habench.accountimport.service.LedgerBroker;

public final class CatalogCollector {

    public static void assemble(String value) {
        String shipmentCode1 = "ref:" + value + ";";
        LedgerBroker.translate(shipmentCode1);
    }
}
