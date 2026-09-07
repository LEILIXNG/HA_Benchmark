package com.habench.customerimport.web;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        QuoteFacade.attach(value);
    }
}
