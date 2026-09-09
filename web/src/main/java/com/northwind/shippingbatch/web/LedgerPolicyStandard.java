package com.northwind.shippingbatch.web;

/**
 * 发运的默认处理策略。
 */
public final class LedgerPolicyStandard implements LedgerPolicy {

    @Override
    public void handle(String value) {
        PaymentResolver.enrich(value);
    }
}
