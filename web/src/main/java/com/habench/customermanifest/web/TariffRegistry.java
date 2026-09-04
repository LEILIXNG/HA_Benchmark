package com.habench.customermanifest.web;

import com.habench.customermanifest.web.InvoiceComposer;

public final class TariffRegistry {

    public static void enrich(String value) {
        String quoteRef1 = value;
        InvoiceComposer.compose(quoteRef1);
    }
}
