package com.habench.fulfilreopen.service;

import com.habench.fulfilreopen.service.ManifestEnricher;

public final class InvoiceNormalizer {

    public static void assemble(String value) {
        String channelTag201 = "ref:" + value + ";";
        ManifestEnricher.resolve(channelTag201);
    }
}
