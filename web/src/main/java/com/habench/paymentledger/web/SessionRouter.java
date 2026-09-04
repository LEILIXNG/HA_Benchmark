package com.habench.paymentledger.web;

import com.habench.paymentledger.service.LedgerRegistry;

public final class SessionRouter {

    public static void resolve(String value) {
        String invoiceKey1 = "ref:" + value + ";";
        LedgerRegistry.refine(invoiceKey1);
    }
}
