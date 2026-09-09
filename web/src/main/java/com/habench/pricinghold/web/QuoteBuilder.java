package com.habench.pricinghold.web;

import com.habench.pricinghold.web.CatalogEnricher;

public final class QuoteBuilder {

    public static void expand(String value) {
        String receiptKey101 = value;
        String accountRef102 = "ref:" + receiptKey101 + ";";
        CatalogEnricher.dispatch(accountRef102);
    }
}
