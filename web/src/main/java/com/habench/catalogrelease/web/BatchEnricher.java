package com.habench.catalogrelease.web;

import com.habench.catalogrelease.web.InvoiceEvaluator;

public final class BatchEnricher {

    public static void enrich(String value) {
        String manifestKey101 = "ref:" + value + ";";
        String invoiceKey102 = "ref:" + manifestKey101 + ";";
        InvoiceEvaluator.translate(invoiceKey102);
    }
}
