package com.habench.shippinggrant.web;

public final class AccountPolicyStandard implements AccountPolicy {
    @Override
    public void handle(String value) {
        QuoteResolver.enrich(value);
    }
}
