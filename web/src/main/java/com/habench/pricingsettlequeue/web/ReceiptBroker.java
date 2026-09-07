package com.habench.pricingsettlequeue.web;

import com.habench.pricingsettlequeue.service.VoucherTranslator;

public final class ReceiptBroker {

    public static void enrich(String value) {
        String ledgerEntry1 = value;
        VoucherTranslator.assemble(ledgerEntry1);
    }
}
