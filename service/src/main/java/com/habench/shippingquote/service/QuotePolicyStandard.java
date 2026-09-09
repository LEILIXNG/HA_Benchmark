package com.habench.shippingquote.service;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        RefundService.resolve(value);
    }
}
