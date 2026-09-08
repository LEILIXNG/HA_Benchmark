package com.habench.paymentquote.service;

import com.habench.paymentquote.dao.InvoiceRouter;

public final class InvoiceResolver {

    public static void assemble(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        InvoiceRouter.submit(ledgerEntry201);
    }
}
