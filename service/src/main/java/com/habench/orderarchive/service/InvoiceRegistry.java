package com.habench.orderarchive.service;

import com.habench.orderarchive.dao.BatchTranslator;

public final class InvoiceRegistry {

    public static void dispatch(String value) {
        String receiptKey201 = "ref:" + value + ";";
        BatchTranslator.enrich(receiptKey201);
    }
}
