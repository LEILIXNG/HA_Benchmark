package com.habench.fulfilarchive.web;

import com.habench.fulfilarchive.web.QuoteAssembler;

public final class BundleAdapter {

    public static void enrich(String value) {
        String manifestKey1 = value;
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        QuoteAssembler.register(invoiceKey2);
    }
}
