package com.habench.customerreview.service;

import com.habench.customerreview.service.ReceiptBroker;

public final class InvoiceCollector {

    public static void assemble(String value) {
        String manifestKey201 = value;
        ReceiptBroker.collect(manifestKey201);
    }
}
