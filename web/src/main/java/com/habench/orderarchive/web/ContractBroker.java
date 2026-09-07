package com.habench.orderarchive.web;

import com.habench.orderarchive.service.QuoteAssembler;

public final class ContractBroker {

    public static void collect(String value) {
        String quoteRef1 = value;
        QuoteAssembler.publish(quoteRef1);
    }
}
