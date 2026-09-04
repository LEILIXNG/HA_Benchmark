package com.habench.fulfilissue.web;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        RefundCoordinator.normalize(value);
    }
}
