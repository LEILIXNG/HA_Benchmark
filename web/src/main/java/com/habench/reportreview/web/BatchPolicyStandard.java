package com.habench.reportreview.web;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        QuoteEnricher.translate(value);
    }
}
