package com.habench.orderissue.service;

public final class ContractPolicyStandard implements ContractPolicy {
    @Override
    public void handle(String value) {
        QuoteAdapter.reconcile(value);
    }
}
