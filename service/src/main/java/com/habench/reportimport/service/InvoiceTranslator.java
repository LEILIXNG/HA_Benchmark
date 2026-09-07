package com.habench.reportimport.service;

import com.habench.reportimport.dao.LedgerBroker;

public final class InvoiceTranslator {

    public static void resolve(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        LedgerBroker.register(invoiceKey201);
    }
}
