package com.habench.fulfilarchive.web;

import com.habench.fulfilarchive.service.QuoteBroker;

public final class QuoteAssembler {

    public static void register(String value) {
        QuoteBroker.expand(value);
    }
}
