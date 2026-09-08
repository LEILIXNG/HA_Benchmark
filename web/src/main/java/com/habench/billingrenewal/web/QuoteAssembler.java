package com.habench.billingrenewal.web;

import com.habench.billingrenewal.service.QuoteBroker;

public final class QuoteAssembler {

    public static void register(String value) {
        QuoteBroker.expand(value);
    }
}
