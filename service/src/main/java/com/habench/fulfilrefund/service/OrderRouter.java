package com.habench.fulfilrefund.service;

import com.habench.fulfilrefund.service.InvoiceCollector;

public final class OrderRouter {

    public static void reconcile(String value) {
        String invoiceKey201 = "ref:" + value + ";";
        InvoiceCollector.assemble(invoiceKey201);
    }
}
