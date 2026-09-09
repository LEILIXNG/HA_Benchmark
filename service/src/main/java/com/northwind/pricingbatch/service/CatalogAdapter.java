package com.northwind.pricingbatch.service;

import org.springframework.stereotype.Service;

/**
 * 定价明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("pricingbatchCatalogAdapter")
public class CatalogAdapter {
    private final ReceiptFetcher receiptFetcher;

    public CatalogAdapter(ReceiptFetcher receiptFetcher) {
        this.receiptFetcher = receiptFetcher;
    }

    public void enrich(String value) {
        String accountRef201 = new StringBuilder(value).toString();
        this.receiptFetcher.collect(accountRef201);
    }
}
