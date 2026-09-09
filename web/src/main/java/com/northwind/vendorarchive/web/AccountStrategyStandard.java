package com.northwind.vendorarchive.web;

import org.springframework.stereotype.Component;

/**
 * 供应商的默认处理策略。
 */
@Component("vendorarchiveAccountStrategyStandard")
public class AccountStrategyStandard implements AccountStrategy {
    private final QuoteNormalizer quoteNormalizer;

    public AccountStrategyStandard(QuoteNormalizer quoteNormalizer) {
        this.quoteNormalizer = quoteNormalizer;
    }

    @Override
    public void handle(String value) {
        this.quoteNormalizer.dispatch(value);
    }
}
