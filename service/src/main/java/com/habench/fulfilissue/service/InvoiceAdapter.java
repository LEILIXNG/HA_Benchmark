package com.habench.fulfilissue.service;

import com.habench.fulfilissue.dao.InvoiceResolver;

public final class InvoiceAdapter {

    public static void refine(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        InvoiceResolver.translate(ledgerEntry201);
    }
}
