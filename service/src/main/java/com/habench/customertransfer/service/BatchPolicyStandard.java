package com.habench.customertransfer.service;

public final class BatchPolicyStandard implements BatchPolicy {
    @Override
    public void handle(String value) {
        QuoteEnricher.assemble(value);
    }
}
