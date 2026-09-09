package com.habench.accountlookup.service;

import com.habench.accountlookup.dao.BatchTranslator;

public final class InvoiceRegistry {

    public static void dispatch(String value) {
        String receiptKey201 = "ref:" + value + ";";
        BatchTranslator.enrich(receiptKey201);
    }
}
