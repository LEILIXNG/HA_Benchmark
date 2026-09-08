package com.habench.reporttrace.web;

import com.habench.reporttrace.web.InvoiceAssembler;

public final class QuoteTranslator {

    public static void dispatch(String value) {
        String accountRef101 = value;
        InvoiceAssembler.normalize(accountRef101);
    }
}
