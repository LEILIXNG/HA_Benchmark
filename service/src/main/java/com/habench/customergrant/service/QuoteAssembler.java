package com.habench.customergrant.service;

import com.habench.customergrant.service.SessionBroker;

public final class QuoteAssembler {

    public static void assemble(String value) {
        String manifestKey101 = value;
        SessionBroker.submit(manifestKey101);
    }
}
