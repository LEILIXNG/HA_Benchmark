package com.habench.fulfilrevise.web;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        OrderEnricher.expand(value);
    }
}
