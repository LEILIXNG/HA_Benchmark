package com.habench.inventorymerge.web;

public final class LedgerPolicyStandard implements LedgerPolicy {
    @Override
    public void handle(String value) {
        SessionCollector.assemble(value);
    }
}
