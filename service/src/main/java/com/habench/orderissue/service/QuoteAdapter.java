package com.habench.orderissue.service;

import com.habench.orderissue.service.LedgerLoader;

public final class QuoteAdapter {

    public static void reconcile(String value) {
        String shipmentCode201 = value;
        String manifestKey202 = "ref:" + shipmentCode201 + ";";
        LedgerLoader.reconcile(manifestKey202);
    }
}
