package com.habench.fulfilledger.web;

import com.habench.fulfilledger.service.InvoiceResolver;

public final class RefundFacade {

    public static void assemble(String value) {
        String orderRef101 = "ref:" + value + ";";
        InvoiceResolver.translate(orderRef101);
    }
}
