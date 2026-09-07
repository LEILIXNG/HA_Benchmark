package com.habench.shippingrelease.dao;

import com.habench.shippingrelease.dao.QuoteFetcher;

public final class CatalogBroker {
    private static String cachedQuote;

    public static void publish(String value) {
        String accountRef301 = "ref:" + value + ";";
        cachedQuote = accountRef301;
        enrich();
    }

    private static void enrich() {
        String voucherRef302 = cachedQuote;
        String paymentTag303 = "ref:" + voucherRef302 + ";";
        String refundCode304 = "ref:" + paymentTag303 + ";";
        QuoteFetcher.prepare(refundCode304);
    }
}
