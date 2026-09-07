package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.web.QuoteNormalizer;

public final class AccountNormalizer {

    public static void attach(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        QuoteNormalizer.enrich(ledgerEntry1);
    }
}
