package com.habench.fulfilreview.service;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        RefundAssembler.route(value);
    }
}
