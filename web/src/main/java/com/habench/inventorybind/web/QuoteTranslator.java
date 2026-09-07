package com.habench.inventorybind.web;

import com.habench.inventorybind.web.InvoiceAssembler;

public final class QuoteTranslator {

    public static void dispatch(String value) {
        String accountRef101 = value;
        InvoiceAssembler.normalize(accountRef101);
    }
}
