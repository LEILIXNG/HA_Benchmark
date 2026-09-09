package com.northwind.fulfilmanifest.service;

/**
 * 履约的默认处理策略。
 */
public final class PaymentPolicyStandard implements PaymentPolicy {

    @Override
    public void handle(String value) {
        QuoteEnricher.resolve(value);
    }
}
