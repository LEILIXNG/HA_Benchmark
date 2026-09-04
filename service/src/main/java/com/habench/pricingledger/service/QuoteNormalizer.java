package com.habench.pricingledger.service;

import com.habench.pricingledger.dao.ManifestEnricher;

public final class QuoteNormalizer {

    public static void attach(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = catalogKey201;
        ManifestEnricher.refine(receiptKey202);
    }
}
