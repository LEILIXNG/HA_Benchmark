package com.habench.pricingexport.dao;

public final class AccountRuleStandard implements AccountRule {
    @Override
    public void handle(String value) {
        QuoteEnricher.route(value);
    }
}
