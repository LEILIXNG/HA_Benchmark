package com.habench.paymentsettle.web;

public final class QuotePolicyStandard implements QuotePolicy {
    @Override
    public void handle(String value) {
        ContractAssembler.reconcile(value);
    }
}
