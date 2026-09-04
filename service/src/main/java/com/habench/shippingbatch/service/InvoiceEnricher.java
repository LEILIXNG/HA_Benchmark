package com.habench.shippingbatch.service;

import com.habench.shippingbatch.dao.LedgerCollector;

public final class InvoiceEnricher {

    public static void register(String value) {
        String invoiceKey201 = value;
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        LedgerCollector.enrich(batchTag202);
    }
}
