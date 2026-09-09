package com.northwind.pricingrefund.dao;

import org.springframework.stereotype.Repository;

/**
 * 定价处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("pricingrefundQuoteNormalizer")
public class QuoteNormalizer {
    private final ReceiptStrategySelector receiptStrategySelector;

    public QuoteNormalizer(ReceiptStrategySelector receiptStrategySelector) {
        this.receiptStrategySelector = receiptStrategySelector;
    }

    public void register(String value) {
        String invoiceKey301 = "ref:" + value + ";";
        this.receiptStrategySelector.stage(invoiceKey301);
    }
}
