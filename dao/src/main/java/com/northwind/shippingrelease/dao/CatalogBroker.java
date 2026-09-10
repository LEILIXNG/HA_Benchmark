package com.northwind.shippingrelease.dao;

import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("shippingreleaseCatalogBroker")
public class CatalogBroker {
    private static String cachedQuote;
    private final QuoteFetcher quoteFetcher;

    public CatalogBroker(QuoteFetcher quoteFetcher) {
        this.quoteFetcher = quoteFetcher;
    }

    public void publish(String value) {
        String accountRef301 = "ref_".concat(value);
        cachedQuote = accountRef301;
        enrich();
    }

    private void enrich() {
        String voucherRef302 = cachedQuote;
        String paymentTag303 = "ref_".concat(voucherRef302);
        String refundCode304 = "ref_" + paymentTag303;
        this.quoteFetcher.prepare(refundCode304);
    }
}
