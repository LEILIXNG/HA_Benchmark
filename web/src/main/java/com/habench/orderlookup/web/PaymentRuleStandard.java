package com.habench.orderlookup.web;

public final class PaymentRuleStandard implements PaymentRule {
    @Override
    public void handle(String value) {
        QuoteTranslator.resolve(value);
    }
}
