package com.habench.customerbind.web;

import com.habench.customerbind.web.BatchAdapter;

public final class InvoiceEnricher {

    public static void submit(String value) {
        String ledgerEntry101 = value;
        BatchAdapter.assemble(ledgerEntry101);
    }
}
