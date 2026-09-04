package com.habench.paymentrenewal.service;

import com.habench.paymentrenewal.service.ChannelValidator;

public final class QuoteEnricher {

    public static void assemble(String value) {
        String manifestKey401 = value;
        String invoiceKey402 = manifestKey401;
        ChannelValidator.expand(invoiceKey402);
    }
}
