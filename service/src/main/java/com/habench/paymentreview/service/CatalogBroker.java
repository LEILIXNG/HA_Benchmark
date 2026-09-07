package com.habench.paymentreview.service;

import com.habench.paymentreview.service.LedgerService;

public final class CatalogBroker {

    public static void enrich(String value) {
        String tariffRef101 = value;
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        LedgerService.dispatch(ledgerEntry102);
    }
}
