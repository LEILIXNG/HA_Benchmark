package com.habench.reportexport.service;

public final class QuoteRuleStandard implements QuoteRule {
    @Override
    public void handle(String value) {
        PaymentCoordinator.translate(value);
    }
}
