package com.habench.inventoryreview.service;

import com.habench.inventoryreview.dao.ReceiptAssembler;

public final class LedgerComposer {

    public static void dispatch(String value) {
        String tariffRef101 = value;
        String ledgerEntry102 = tariffRef101;
        ReceiptAssembler.enrich(ledgerEntry102);
    }
}
