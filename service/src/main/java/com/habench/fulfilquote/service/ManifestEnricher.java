package com.habench.fulfilquote.service;

import com.habench.fulfilquote.service.ReceiptNormalizer;

public final class ManifestEnricher {

    public static void prepare(String value) {
        String quoteRef101 = "ref:" + value + ";";
        ReceiptNormalizer.translate(quoteRef101);
    }
}
