package com.habench.accountlookup.web;

import com.habench.accountlookup.service.QuoteAssembler;

public final class ContractBroker {

    public static void collect(String value) {
        String quoteRef1 = value;
        QuoteAssembler.publish(quoteRef1);
    }
}
