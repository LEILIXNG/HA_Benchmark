package com.habench.billingassign.web;

import com.habench.billingassign.service.InvoiceEnricher;

public final class LedgerService {

    public static void refine(String value) {
        String catalogKey1 = "ref:" + value + ";";
        String receiptKey2 = "ref:" + catalogKey1 + ";";
        InvoiceEnricher.enrich(receiptKey2);
    }
}
