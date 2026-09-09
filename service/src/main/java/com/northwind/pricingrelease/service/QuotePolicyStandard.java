package com.northwind.pricingrelease.service;

/**
 * 定价的默认处理策略。
 */
public final class QuotePolicyStandard implements QuotePolicy {

    @Override
    public void handle(String value) {
        BundleResolver.route(value);
    }
}
