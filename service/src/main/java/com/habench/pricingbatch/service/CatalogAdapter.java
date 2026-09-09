package com.habench.pricingbatch.service;

import com.habench.pricingbatch.service.ReceiptFetcher;

public final class CatalogAdapter {

    public static void enrich(String value) {
        String accountRef201 = value;
        ReceiptFetcher.collect(accountRef201);
    }
}
