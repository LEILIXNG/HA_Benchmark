package com.habench.billingrenewal.web;

import com.habench.billingrenewal.web.QuoteAssembler;

public final class BundleAdapter {

    public static void enrich(String value) {
        String manifestKey1 = value;
        String invoiceKey2 = "ref:" + manifestKey1 + ";";
        QuoteAssembler.register(invoiceKey2);
    }
}
