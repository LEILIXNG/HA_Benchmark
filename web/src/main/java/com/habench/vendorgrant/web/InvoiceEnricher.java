package com.habench.vendorgrant.web;

import com.habench.vendorgrant.service.QuoteRegistry;

public final class InvoiceEnricher {

    public static void resolve(String value) {
        String channelTag201 = value;
        QuoteRegistry.prepare(channelTag201);
    }
}
